package art.class34.class5; 
 
import art.genericty.Addresser; 
 
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
 
        FileClassLoader classLoader = new FileClassLoader("D:\\develop\\code\\Java\\idea\\LeetCode\\out\\production\\LeetCode\\"); 
        System.out.println(classLoader); 
        try { 
            Class<?> person = classLoader.loadClass("art.class34.class5.Person"); 
            try { 
                System.out.println(Addresser.addressOf(person)); 
                System.out.println(Person.i); 
                Person.i = 100; 
                System.out.println(Person.i); 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            Class<?> person2 = classLoader.loadClass("art.class34.class5.Person"); 
            try { 
                System.out.println("旧的person的地址" + Addresser.addressOf(person)); 
                System.out.println(Person.i); 
                Person.i = 25333; 
                System.out.println(Person.i); 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            try { 
                System.out.println(Addresser.addressOf(Person.class)); 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            Constructor<?> constructor = person.getConstructor(String.class); 
            Object lihua = constructor.newInstance("lihua"); 
            System.out.println(lihua); 
 
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) { 
            e.printStackTrace(); 
        } 
        classLoader = null; 
 
 
        System.gc(); 
 
 
        System.out.println("================"); 
 
        try { 
            System.out.println(Addresser.addressOf(Person.class)); 
            System.out.println(Person.i); 
 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
 
        classLoader = new FileClassLoader("D:\\develop\\code\\Java\\idea\\LeetCode\\out\\production\\LeetCode\\"); 
        System.out.println(classLoader); 
        try { 
            Class<?> person = classLoader.loadClass("art.class34.class5.Person"); 
            try { 
                System.out.println(Addresser.addressOf(person)); 
                System.out.println(Person.i); 
                Person.i = 567; 
                System.out.println(Person.i); 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            Class<?> person2 = classLoader.loadClass("art.class34.class5.Person"); 
            try { 
                System.out.println("新的person的地址" + Addresser.addressOf(person)); 
                System.out.println(Person.i); 
                Person.i = 124153; 
                System.out.println(Person.i); 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            Constructor<?> constructor = person.getConstructor(String.class); 
            Object lihua = constructor.newInstance("lihua"); 
            System.out.println(lihua); 
 
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) { 
            e.printStackTrace(); 
        } 
 
 
    } 
 
} 
