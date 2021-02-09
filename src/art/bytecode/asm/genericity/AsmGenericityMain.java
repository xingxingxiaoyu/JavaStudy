package art.bytecode.asm.genericity;

import art.bytecode.asm.ClassPrinter;
import art.class34.class5.FileClassLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class AsmGenericityMain {
    public static void main(String[] args) throws Throwable {
        ClassReader classReader = new ClassReader(AsmGenericityTest.class.getName());
        ClassWriter classWriter = new ClassWriter(3);
        GenericityClassVisitor timeClassVisitor = new GenericityClassVisitor(classWriter);
        System.out.println("======================start=======================");
        classReader.accept(timeClassVisitor, ClassReader.EXPAND_FRAMES);
        System.out.println("======================end================================");

        ClassPrinter.saveAndPrintClass(classWriter, AsmGenericityTest.class.getName());

        Class<?> aClass = new FileClassLoader("D:\\develop\\code\\IdeaProjects\\LeetCode\\out\\production\\LeetCode", Object.class.getClassLoader()).loadClass(AsmGenericityTest.class.getName());
        aClass.getDeclaredMethod("testPrint").invoke(null);

    }
}
