package art.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class SimpleDemo {
    public static void main(String[] args) {
        try {
            Method test = SimpleDemo.class.getDeclaredMethod("test", String.class);
            System.out.println(((Demo)test.getParameterAnnotations()[0][0]).value());
            System.out.println(test.getParameters()[0].getType());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void test(@Demo(value = "xujiafeng") String a) {

    }
}

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface Demo {
    String value();

}