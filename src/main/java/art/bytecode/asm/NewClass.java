package art.bytecode.asm;

import art.class34.class5.FileClassLoader;
import art.reflect.ReflectionUtil;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

import static org.objectweb.asm.Opcodes.*;

public class NewClass {
    public static void main(String[] args) throws Throwable {
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(V1_8, ACC_PUBLIC,
                "org/by/Cwtest", null, "java/lang/Object",
//                new String[]{"org/by/ICw"}
                null
        );

        classWriter.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "testFieldString", "Ljava/lang/String;", null, "xuyu").visitEnd();
        classWriter.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "testFieldInt", "I", null, new Integer(1024)).visitEnd();
//        classWriter.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "testMethod", "(Ljava/lang/String;)V", null, null).visitEnd();
        classWriter.visitEnd();

        ClassPrinter.saveAndPrintClass(classWriter, "org.by.Cwtest");
    }

}
