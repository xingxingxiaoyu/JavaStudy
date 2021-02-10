package art.bytecode.asm;

import art.class34.class5.FileClassLoader;
import art.reflect.ReflectionUtil;
import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassPrinter extends ClassVisitor {
    public ClassPrinter() {
        super(Opcodes.ASM6);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + " extend " + superName + " implements " + interfaces);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println(" " + descriptor + " " + name);
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println(" " + name + descriptor);
        return null;
    }

    public static void main(String[] args) throws IOException {
        ClassPrinter classPrinter = new ClassPrinter();

        InputStream cl = ClassLoader.getSystemResourceAsStream(AsmDemo.class.getName().replace(".", "/") + ".class");
        ClassReader classReader = new ClassReader(cl);

        classReader.accept(classPrinter, 0);

    }

    public static void saveAndPrintClass(ClassWriter classWriter, String className) throws Throwable {
        File file = new File("D://asmClass/" + className.replace('.', '/') + ".class");
        String parent = file.getParent();
        File parentFile = new File(parent);
        parentFile.mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(classWriter.toByteArray());
        fileOutputStream.flush();

//        Class<?> aClass = new FileClassLoader("D://asmClass/", Object.class.getClassLoader()).loadClass(className);
//        ReflectionUtil.printClass(aClass);
    }
}