package art.proxy;

import art.reflect.ReflectionUtil;

public class Test {
    public static void main(String[] args) {
        Person tony = new Person("Tony", 1);
        LogHandler<IPrint> logHandler = new LogHandler<>(tony);
        IPrint iPrint =  logHandler.newProxyInstance(tony);
        iPrint.print();
        iPrint.toString();

        System.out.println(iPrint.getClass());

        ReflectionUtil.print(iPrint.getClass());

    }
}
