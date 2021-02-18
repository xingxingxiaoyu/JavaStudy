package art.bytecode.asm.old.method;

import art.bytecode.asm.old.ClassPrinter;
import art.class34.class5.FileClassLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class AsmMethodMain {
    public static void main(String[] args) throws Throwable {
        ClassReader classReader = new ClassReader(AsmMethodTest.class.getName());
        ClassWriter classWriter = new ClassWriter(3);
        TimeClassVisitor timeClassVisitor = new TimeClassVisitor(classWriter);
        System.out.println("======================start=======================");
        classReader.accept(timeClassVisitor, ClassReader.EXPAND_FRAMES);
        System.out.println("======================end================================");

        ClassPrinter.saveAndPrintClass(classWriter, AsmMethodTest.class.getName());

        Class<?> aClass = new FileClassLoader("asmClass/", Object.class.getClassLoader()).loadClass(AsmMethodTest.class.getName());
        aClass.getDeclaredMethod("testPrint").invoke(null);

    }
}
