package art.reflect;


import art.proxy.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Class aClass1 = Person.class;
        Class aClass2 = "".getClass();
        try {
            Class aClass3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = aClass1.getMethods();
        Method[] methods2 = aClass1.getDeclaredMethods();


        Field[] fields = aClass1.getFields();
        Field[] fields2 = aClass1.getDeclaredFields();

        for (int i = 0; i < fields2.length; i++) {
            System.out.println(fields2[i].getName());
        }

        Constructor[] constructors = aClass1.getConstructors();
        Constructor[] constructors2 = aClass1.getDeclaredConstructors();

        try {
            Field field = Person.class.getDeclaredField("name");
            field.setAccessible(true);

            String name = (String) field.get(new Person("Tony",24));
            System.out.println(name);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
