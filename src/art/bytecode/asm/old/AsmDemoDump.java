package art.bytecode.asm.old; 
import org.objectweb.asm.AnnotationVisitor; 
import org.objectweb.asm.Attribute; 
import org.objectweb.asm.ClassReader; 
import org.objectweb.asm.ClassWriter; 
import org.objectweb.asm.ConstantDynamic; 
import org.objectweb.asm.FieldVisitor; 
import org.objectweb.asm.Handle; 
import org.objectweb.asm.Label; 
import org.objectweb.asm.MethodVisitor; 
import org.objectweb.asm.Opcodes; 
import org.objectweb.asm.Type; 
import org.objectweb.asm.TypePath; 
public class AsmDemoDump implements Opcodes { 
 
    public static byte[] dump () throws Exception { 
 
        ClassWriter classWriter = new ClassWriter(0); 
        FieldVisitor fieldVisitor; 
        MethodVisitor methodVisitor; 
        AnnotationVisitor annotationVisitor0; 
 
        classWriter.visit(V13, ACC_PUBLIC | ACC_SUPER, "art/bytecode/asm/AsmDemo", null, "java/lang/Object", null); 
 
        classWriter.visitSource("AsmDemo.java", null); 
 
        { 
            fieldVisitor = classWriter.visitField(ACC_PRIVATE | ACC_STATIC, "aString", "Ljava/lang/String;", null, null); 
            fieldVisitor.visitEnd(); 
        } 
        { 
            fieldVisitor = classWriter.visitField(ACC_PRIVATE | ACC_STATIC, "aInt", "I", null, null); 
            fieldVisitor.visitEnd(); 
        } 
        { 
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null); 
            methodVisitor.visitCode(); 
            Label label0 = new Label(); 
            methodVisitor.visitLabel(label0); 
            methodVisitor.visitLineNumber(8, label0); 
            methodVisitor.visitVarInsn(ALOAD, 0); 
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false); 
            Label label1 = new Label(); 
            methodVisitor.visitLabel(label1); 
            methodVisitor.visitLineNumber(9, label1); 
            methodVisitor.visitInsn(RETURN); 
            Label label2 = new Label(); 
            methodVisitor.visitLabel(label2); 
            methodVisitor.visitLocalVariable("this", "Lart/bytecode/asm/AsmDemo;", null, label0, label2, 0); 
            methodVisitor.visitMaxs(1, 1); 
            methodVisitor.visitEnd(); 
        } 
        { 
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "testPrint", "(Ljava/lang/String;)V", null, new String[] { "java/lang/Exception" }); 
            methodVisitor.visitCode(); 
            Label label0 = new Label(); 
            methodVisitor.visitLabel(label0); 
            methodVisitor.visitLineNumber(12, label0); 
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); 
            methodVisitor.visitVarInsn(ALOAD, 1); 
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); 
            Label label1 = new Label(); 
            methodVisitor.visitLabel(label1); 
            methodVisitor.visitLineNumber(13, label1); 
            methodVisitor.visitLdcInsn("xuysfhskjdf"); 
            methodVisitor.visitFieldInsn(PUTSTATIC, "art/bytecode/asm/AsmDemo", "aString", "Ljava/lang/String;"); 
            Label label2 = new Label(); 
            methodVisitor.visitLabel(label2); 
            methodVisitor.visitLineNumber(14, label2); 
            methodVisitor.visitTypeInsn(NEW, "java/lang/Exception"); 
            methodVisitor.visitInsn(DUP); 
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Exception", "<init>", "()V", false); 
            methodVisitor.visitInsn(ATHROW); 
            Label label3 = new Label(); 
            methodVisitor.visitLabel(label3); 
            methodVisitor.visitLocalVariable("this", "Lart/bytecode/asm/AsmDemo;", null, label0, label3, 0); 
            methodVisitor.visitLocalVariable("a", "Ljava/lang/String;", null, label0, label3, 1); 
            methodVisitor.visitMaxs(2, 2); 
            methodVisitor.visitEnd(); 
        } 
        { 
            methodVisitor = classWriter.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null); 
            methodVisitor.visitCode(); 
            Label label0 = new Label(); 
            methodVisitor.visitLabel(label0); 
            methodVisitor.visitLineNumber(5, label0); 
            methodVisitor.visitLdcInsn("xuyu"); 
            methodVisitor.visitFieldInsn(PUTSTATIC, "art/bytecode/asm/AsmDemo", "aString", "Ljava/lang/String;"); 
            Label label1 = new Label(); 
            methodVisitor.visitLabel(label1); 
            methodVisitor.visitLineNumber(6, label1); 
            methodVisitor.visitIntInsn(SIPUSH, 1024); 
            methodVisitor.visitFieldInsn(PUTSTATIC, "art/bytecode/asm/AsmDemo", "aInt", "I"); 
            methodVisitor.visitInsn(RETURN); 
            methodVisitor.visitMaxs(1, 0); 
            methodVisitor.visitEnd(); 
        } 
        classWriter.visitEnd(); 
 
        return classWriter.toByteArray(); 
    } 
} 
