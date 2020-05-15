package art.class34.class5;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Class5 {
    public static void main(String[] args) {
        String cp = System.getProperty("java.class.path");
        System.out.println(cp);
        ClassLoader appClassLoader = Class5.class.getClassLoader();
        System.out.println(appClassLoader.getClass().getName());
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader.getClass().getName());
        System.out.println(extClassLoader.getParent());

        FileClassLoader classLoader = new FileClassLoader("D:\\develop\\code\\Java\\idea\\Test\\out\\production\\Test\\");
        try {
            Class<?> person = classLoader.loadClass("com.example.test.Person");
            Constructor<?> constructor = person.getConstructor(String.class);
            Object lihua = constructor.newInstance("lihua");
            System.out.println(lihua);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}
