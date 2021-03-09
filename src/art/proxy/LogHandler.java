package art.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogHandler<T> implements InvocationHandler {

    private T targetObject;

    public LogHandler(T targetObject) {
        this.targetObject = targetObject;
    }

    public T newProxyInstance(T targetObject) {
        return (T) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        System.out.println("invoke start");
        Object result = method.invoke(targetObject, objects);
        System.out.println("invoke end");
        return result;
    }
}
