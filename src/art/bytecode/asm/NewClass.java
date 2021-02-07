package art.bytecode.asm;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

import static org.objectweb.asm.Opcodes.*;

public class NewClass {
    public static void main(String[] args) throws Throwable {
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(V1_7, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "org/by/Cwtest", null, "java/lang/Object",
                new String[]{"org/by/ICw"});

        classWriter.visitField(ACC_PUBLIC, "testFieldString", "java/lang/String", null, "xuyu").visitEnd();
        classWriter.visitField(ACC_PUBLIC, "testFieldInt", "I", null, 1024).visitEnd();
        classWriter.visitEnd();
        File file = new File("org/by/Cwtest.class");
        String parent = file.getParent();
        File parentFile = new File(parent);
        parentFile.mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(classWriter.toByteArray());
    }
}
