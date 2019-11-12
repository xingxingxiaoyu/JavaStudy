package art.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;


public class ReflectionUtil {
    public static void print(Class c1) {

        try {
            Class superc1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print("class " + c1.getName());
            if (superc1 != null && superc1 != Object.class)
                System.out.print("extends " + superc1.getName());
            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void printConstructors(Class c1) {
        Constructor[] constructors = c1.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }


    public static void printMethods(Class c1) {
        Method[] methods = c1.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("  ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            Class[] paraTypes = m.getParameterTypes();
            for (int i = 0; i < paraTypes.length; i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paraTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class c1) {
        Field[] fields = c1.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
//            if (modifiers.length() > 0)
                System.out.println(type.getName() + " " + name + ";");
        }
    }

}