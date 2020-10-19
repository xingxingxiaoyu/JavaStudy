package art.bytecode.yuan;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestMain {

    public static void main(String[] args) {
        Test test = new Test();
        B b = new B();

        System.out.println("替换前");
        System.out.println(test.a.selfIntroduction());

        TKt.replaceObject(test, "a", b);

        System.out.println("强转前");
        System.out.println(test.a.selfIntroduction());
        System.out.println(test.a.testField);
        System.out.println(test.a.getClass());

        System.out.println("强转后");
        Object obb = test.a;
        System.out.println(((B) obb).selfIntroduction());
        System.out.println(((B) obb).testField);
    }
}

final class A {

    String selfIntroduction() {
        return "I'm A";
    }

    String testField = "I'm A field";
}

class B {

    String selfIntroduction() {
        return "I'm B";
    }

    String testField2 = "I'm B field22222222222";
    String testField = "I'm B field";

}

class Test {
    public final A a = new A();
}


class TKt {
    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replaceObject(Object obj, String fieldName, Object newField) {

        try {
            Field nameField = Test.class.getDeclaredField(fieldName);
            long fieldOffset = unsafe.objectFieldOffset(nameField);
            System.out.println(fieldOffset);
            unsafe.putObject(obj, fieldOffset, newField);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
