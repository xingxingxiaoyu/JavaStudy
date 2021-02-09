package art.bytecode.asm.method;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.AnalyzerAdapter;
import org.objectweb.asm.commons.LocalVariablesSorter;

import static org.objectweb.asm.Opcodes.*;

public class TimeClassVisitor extends ClassVisitor {
    public TimeClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM7, classVisitor);
    }

    private String owner;
    private boolean isInterface;


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        System.out.println("visit");
        owner = name;
        isInterface = (access & ACC_INTERFACE) != 0;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("visitMethod   start");
        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);
        if (!isInterface && mv != null && !name.equals("<init>")) {
            AddTimerMethodAdapter at = new AddTimerMethodAdapter(mv);
            at.aa = new AnalyzerAdapter(owner, access, name, descriptor, at);
            at.lvs = new LocalVariablesSorter(access, descriptor, at.aa);
            System.out.println("visitMethod   end");

            return at.lvs;
        }
        System.out.println("visitMethod   end");

        return mv;
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        System.out.println("visitEnd");
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

    static class AddTimerMethodAdapter extends MethodVisitor {
        private int time;
        private int maxStack;
        public LocalVariablesSorter lvs;
        public AnalyzerAdapter aa;

        public AddTimerMethodAdapter(MethodVisitor methodVisitor) {
            super(ASM7, methodVisitor);
        }


        private void throwException() {
            Label label2 = new Label();
            mv.visitLabel(label2);
            mv.visitLineNumber(14, label2);
            mv.visitTypeInsn(NEW, "java/lang/Exception");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Exception", "<init>", "()V", false);
            mv.visitInsn(ATHROW);
        }

        @Override
        public void visitCode() {
            System.out.println("visitCode");
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "nanoTime", "()J", false);
            time = lvs.newLocal(Type.LONG_TYPE);
            mv.visitVarInsn(LSTORE, time);
            maxStack = 4;
        }

        @Override
        public void visitInsn(int opcode) {
            System.out.println("visitInsn " + opcode);
            if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {

                mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "nanoTime", "()J", false);
                mv.visitVarInsn(LLOAD, time);
                mv.visitInsn(LSUB);
                mv.visitVarInsn(LSTORE, time);

                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                mv.visitVarInsn(LLOAD, time);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
                maxStack = Math.max(aa.stack.size() + 4, maxStack);
                throwException();
            }
            mv.visitInsn(opcode);
        }

        @Override
        public void visitEnd() {
            System.out.println("method visitEnd");
            super.visitEnd();
        }

        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
            super.visitFieldInsn(opcode, owner, name, descriptor);
            System.out.println("visitFieldInsn" + opcode + owner + name + descriptor);
        }

        @Override
        public void visitVarInsn(int opcode, int var) {
            super.visitVarInsn(opcode, var);
            System.out.println("visitVarInsn" + opcode);
        }

        @Override
        public void visitParameter(String name, int access) {
            super.visitParameter(name, access);
            System.out.println("visitParameter" + name);
        }

        @Override
        public void visitMaxs(int maxStack, int maxLocals) {
            System.out.println("visitMaxs");
            super.visitMaxs(Math.max(maxStack, this.maxStack), maxLocals);
        }
    }
}
