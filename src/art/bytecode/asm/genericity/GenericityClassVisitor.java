package art.bytecode.asm.genericity;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.AnalyzerAdapter;
import org.objectweb.asm.commons.LocalVariablesSorter;

import static org.objectweb.asm.Opcodes.*;

public class GenericityClassVisitor extends ClassVisitor {
    public GenericityClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM7, classVisitor);
    }

//    @Override
//    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
//        super.visit(version, access, name, signature, superName, interfaces);
//    }


//    @Override
//    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
//        System.out.println("visitMethod   start name " + name + " descriptor " + descriptor + " signature " + signature);
//        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
//        if (name.equals("test")) {
//            return new MyMethodVisitor(mv);
//        }
//        return mv;
//    }
//
//    @Override
//    public void visitEnd() {
//        super.visitEnd();
//        System.out.println("visitEnd");
//    }
//
//    @Override
//    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
//        System.out.println("visitAnnotation " + descriptor);
//        return super.visitAnnotation(descriptor, visible);
//
//    }
//
//    @Override
//    public void visitAttribute(Attribute attribute) {
//        super.visitAttribute(attribute);
//        System.out.println("visitAttribute");
//    }
//
//    @Override
//    public void visitSource(String source, String debug) {
//        super.visitSource(source, debug);
//        System.out.println("visitSource");
//    }
//
//    static class MyMethodVisitor extends MethodVisitor {
//        public MyMethodVisitor(MethodVisitor methodVisitor) {
//            super(ASM7, methodVisitor);
//        }
//
//        @Override
//        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
//            System.out.println("visitAnnotation " + descriptor + " visible " + visible);
//            return super.visitAnnotation(descriptor, visible);
//        }
//    }
}
