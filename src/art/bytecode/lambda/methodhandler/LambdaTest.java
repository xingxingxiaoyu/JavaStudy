package art.bytecode.lambda.methodhandler;

import art.reflect.ReflectionUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LambdaTest {
    public static void main(String[] args) throws Exception {
        Runnable r = () -> {

            System.out.println("hello, lambda");

            try {
                Class<?> aClass = Class.forName("jdk.internal.reflect.Reflection");
                Method getCallerClass = aClass.getDeclaredMethod("getCallerClass");

                System.out.println(getCallerClass.invoke(null));

            } catch (Exception e) {
                e.printStackTrace();
            }


            try {
                Method getCallerClass = Class.forName("sun.reflect.Reflection").getDeclaredMethod("getCallerClass", int.class);
                int index = 0;
                Class<?> callerClass;
                while ((callerClass = (Class<?>) getCallerClass.invoke(null, index)) != null) {
                    System.out.println(callerClass);
                    index++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            try {
                Class<?> aClass = Class.forName("art.bytecode.lambda.methodhandler.LambdaTest$$Lambda$1/1023892928");
                System.out.println(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            throw new RuntimeException();
        };


        ReflectionUtil.print(r.getClass());

        Constructor constructor = r.getClass().getDeclaredConstructor(null);
        constructor.setAccessible(true);
        ((Runnable) constructor.newInstance(null)).run();

//        for (int i = 0; i < 3; i++) {
//            Runnable runnable = () -> {
//            };
//            System.out.println(runnable.getClass().getName());
//        }
//
//        for (int i = 0; i < 3; i++) {
//            Runnable runnable = () -> {
//            };
//            System.out.println(runnable.getClass().getName());
//        }
//        for (int i = 0; i < 3; i++) {
//            Runnable runnable = () -> {
//            };
//            System.out.println(runnable.getClass().getName());
//        }


        test(String::length);
        test(s -> s.length());
        r.run();
        LambdaTest.class.getDeclaredMethod("lambda$main$0").invoke(null);
    }

    private static void test(ILambda iLambda) {
        System.out.println(iLambda.test("safsdfa"));
    }
}

interface ILambda {
    int test(String s);
}
