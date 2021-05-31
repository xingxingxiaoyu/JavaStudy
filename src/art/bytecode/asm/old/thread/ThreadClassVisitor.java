package art.bytecode.asm.old.thread; 
 
import org.objectweb.asm.*; 
 
import static org.objectweb.asm.Opcodes.*; 
 
import static org.objectweb.asm.Opcodes.ASM7; 
 
public class ThreadClassVisitor extends ClassVisitor { 
    public ThreadClassVisitor(ClassVisitor classVisitor) { 
        super(Opcodes.ASM7, classVisitor); 
    } 
 
    @Override 
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) { 
        super.visit(version, access, name, signature, superName, interfaces); 
    } 
 
 
    @Override 
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) { 
        System.out.println("visitMethod   start name " + name + " descriptor " + descriptor + " signature " + signature); 
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions); 
        if (name.equals("main")) { 
            return new MyMethodVisitor(mv); 
        } 
        return mv; 
    } 
 
    @Override 
    public void visitEnd() { 
        super.visitEnd(); 
        System.out.println("visitEnd"); 
    } 
 
    @Override 
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) { 
        System.out.println("visitAnnotation " + descriptor); 
        return super.visitAnnotation(descriptor, visible); 
 
    } 
 
    @Override 
    public void visitAttribute(Attribute attribute) { 
        super.visitAttribute(attribute); 
        System.out.println("visitAttribute"); 
    } 
 
    @Override 
    public void visitSource(String source, String debug) { 
        super.visitSource(source, debug); 
        System.out.println("visitSource"); 
    } 
 
    static class MyMethodVisitor extends MethodVisitor { 
        public MyMethodVisitor(MethodVisitor methodVisitor) { 
            super(ASM7, methodVisitor); 
        } 
 
 
        @Override 
        public void visitTypeInsn(int opcode, String type) { 
            System.out.println("visitTypeInsn: " + opcode + " type " + type); 
            if (opcode == NEW && "java/lang/Thread".equals(type)) { 
                mv.visitTypeInsn(NEW, "art/bytecode/asm/old/thread/FakeThread"); 
            } 
        } 
 
        @Override 
        public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) { 
            if (opcode == INVOKEVIRTUAL && "java/lang/Thread".equals(owner) && "start".equals(name)) { 
                super.visitMethodInsn(opcode, "art/bytecode/asm/old/thread", name, descriptor, isInterface); 
            } 
        } 
 
        @Override 
        public void visitMaxs(int maxStack, int maxLocals) { 
            super.visitMaxs(maxStack + 10, maxLocals + 10); 
        } 
        // 
//        @Override 
//        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) { 
//            System.out.println("visitAnnotation " + descriptor + " visible " + visible); 
//            return super.visitAnnotation(descriptor, visible); 
//        } 
// 
//        private boolean flag = false; 
// 
//        @Override 
//        public void visitTypeInsn(int opcode, String type) { 
//            System.out.println("visitTypeInsn: " + opcode + " type " + type); 
//            if (opcode == NEW && "java/lang/Thread".equals(type)) { 
// 
//                flag = true; 
//                mv.visitFieldInsn(GETSTATIC, "art/bytecode/asm/old/thread/AsmThreadTest", "executor", "Ljava/util/concurrent/Executor;"); 
//            } 
//        } 
 
//        @Override 
//        public void visitInsn(int opcode) { 
//            System.out.println("visitInsn: " + opcode); 
//            if (opcode == DUP && flag) { 
//                flag = false; 
//                return; 
//            } 
//            super.visitInsn(opcode); 
//        } 
// 
//        @Override 
//        public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) { 
//            System.out.println("visitMethodInsn: " + opcode); 
//            if (opcode == INVOKEVIRTUAL && "java/lang/Thread".equals(owner)) { 
//                if ("<init>".equals(name)) { 
//                    mv.visitMethodInsn(INVOKEINTERFACE, "java/util/concurrent/Executor", "execute", "(Ljava/lang/Runnable;)V", true); 
//                } else if ("start".equals(name)) { 
// 
//                } else { 
//                    super.visitMethodInsn(opcode, owner, name, descriptor, isInterface); 
//                } 
//            } 
//        } 
    } 
} 
