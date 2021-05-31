package art.bytecode.test; 
 
import java.lang.reflect.Method; 
 
public interface Animal<T> { 
    void eat(T t); 
} 
 
class Dog implements Animal<String> { 
 
    @Override 
    public void eat(String s) { 
        System.out.println(s.getClass().getName()); 
    } 
 
    public static void main(String[] args) { 
        Dog dog = new Dog(); 
        try { 
            Method[] declaredMethods = dog.getClass().getDeclaredMethods(); 
            for (int i = 0; i < declaredMethods.length; i++) { 
                Method declaredMethod = declaredMethods[i]; 
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes(); 
                System.out.println(declaredMethod.toGenericString()); 
                if (parameterTypes[0] == Object.class) { 
                    System.out.println(i); 
                    declaredMethod.invoke(dog, "new Object()"); 
                    System.out.println(declaredMethod.isBridge()); 
                    System.out.println(declaredMethod.isSynthetic()); 
                } 
            } 
 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
 
 
    } 
     
} 
