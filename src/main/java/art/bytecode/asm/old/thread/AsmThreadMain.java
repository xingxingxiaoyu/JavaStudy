package art.bytecode.asm.old.thread;

import art.bytecode.asm.old.ClassPrinter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class AsmThreadMain {
    public static void main(String[] args) throws Throwable {
        for (int i = 0; i < 2; i++) {
            ClassReader classReader;
            if (i >= 1) {
                classReader = new ClassReader(AsmThreadTest.class.getName() + "$" + i);
                ClassWriter classWriter = new ClassWriter(3);
                ThreadClassVisitor timeClassVisitor = new ThreadClassVisitor(classWriter);
                System.out.println("======================start=======================");
                classReader.accept(timeClassVisitor, ClassReader.EXPAND_FRAMES);
                System.out.println("======================end================================");
                ClassPrinter.saveAndPrintClass(classWriter, AsmThreadTest.class.getName() + "$" + i);
            } else {
                classReader = new ClassReader(AsmThreadTest.class.getName());
                ClassWriter classWriter = new ClassWriter(3);
                ThreadClassVisitor timeClassVisitor = new ThreadClassVisitor(classWriter);
                System.out.println("======================start=======================");
                classReader.accept(timeClassVisitor, ClassReader.EXPAND_FRAMES);
                System.out.println("======================end================================");
                ClassPrinter.saveAndPrintClass(classWriter, AsmThreadTest.class.getName());
            }

        }


    }
}
