package art.bytecode.asm.old; 
 
import org.objectweb.asm.*; 
import org.objectweb.asm.util.ASMifier; 
 
import static org.objectweb.asm.Opcodes.*; 
 
import java.util.Arrays; 
 
public class MyClassVisitor extends ClassVisitor { 
    public MyClassVisitor(ClassVisitor classVisitor) { 
        super(Opcodes.ASM7, classVisitor); 
    } 
 
    @Override 
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) { 
        System.out.println("access:" + access + " name:" + name + " descriptor:" + descriptor + " signature:" + signature + " value:" + value); 
        return super.visitField(access, name, descriptor, signature, value); 
    } 
 
    @Override 
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) { 
        System.out.println("access:" + access + " name:" + name + " descriptor:" + descriptor + " signature:" + signature + " exceptions:" + Arrays.toString(exceptions)); 
        if (name.contains("test")) { 
            System.out.println("method " + name + " delete"); 
            return null; 
        } else { 
            return super.visitMethod(access, name, descriptor, signature, exceptions); 
        } 
    } 
 
    @Override 
    public void visitEnd() { 
        //娌℃湁杩欎釜瀛楁 
        FieldVisitor fv = this.cv.visitField(ACC_PUBLIC, "testFiledNameAdd", "I", null, null); 
        if (fv != null) { 
            fv.visitEnd(); 
        } 
        super.visitEnd(); 
    } 
 
    public static void main(String[] args) throws Throwable { 
 
        ClassWriter classWriter = new ClassWriter(3); 
        MyClassVisitor myClassVisitor = new MyClassVisitor(classWriter); 
        ClassReader classReader = new ClassReader(AsmDemo.class.getName()); 
        classReader.accept(myClassVisitor, ClassReader.EXPAND_FRAMES); 
 
        System.out.println("=========="); 
        ClassPrinter.saveAndPrintClass(classWriter, AsmDemo.class.getName()); 
 
        System.out.println("=========="); 
 
//        ClassWriter cw = new ClassWriter(3); 
//        TraceClassVisitor tv = new TraceClassVisitor(cw, new PrintWriter(System.out)); 
// 
//        tv.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, 
//                "org/by/Cwtest", null, "java/lang/Object", 
//                null); 
//        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "LESS", "I", 
//                null, new Integer(-1)).visitEnd(); 
//        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "EQUAL", "I", 
//                null, new Integer(0)).visitEnd(); 
//        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "GRATER", "I", 
//                null, new Integer(1)).visitEnd(); 
// 
//        tv.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", 
//                null, null).visitEnd(); 
// 
//        tv.visitEnd(); 
// 
// 
        ASMifier.main(new String[]{AsmDemo.class.getName()}); 
    } 
} 
