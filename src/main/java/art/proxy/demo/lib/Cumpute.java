package art.proxy.demo.lib;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Cumpute {
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> aClass) {
        return (T) Proxy.newProxyInstance(aClass.getClassLoader(), new Class[]{aClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objects);
                }
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                if (declaredAnnotations.length > 1) {
                    throw new RuntimeException("Annotation can't have more then one");
                }
                Annotation mAnnotation = declaredAnnotations[0];
                int result = 0;
                if (mAnnotation.annotationType() == Add.class) {
                    result = 0;
                    for (int i = 0; i < objects.length; i++) {
                        result += (int) objects[i];
                    }
                } else if (mAnnotation.annotationType() == Minus.class) {
                    result = (int) objects[0];
                    for (int i = 1; i < objects.length; i++) {
                        result -= (int) objects[i];
                    }
                } else if (mAnnotation.annotationType() == Multiply.class) {
                    result = 1;
                    for (int i = 0; i < objects.length; i++) {
                        result *= (int) objects[i];
                    }
                } else if (mAnnotation.annotationType() == Divide.class) {
                    result = (int) objects[0];
                    for (int i = 1; i < objects.length; i++) {
                        result /= (int) objects[i];
                    }
                }
                return result;
            }
        });

    }
}
