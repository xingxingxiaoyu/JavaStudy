package art.proxy.demo;

import art.proxy.demo.lib.Cumpute;

public class TestProxy {
    public static void main(String[] args) {
        ITest instance = Cumpute.getInstance(ITest.class);
        System.out.println(instance.getOne(1, 2, 3));
        System.out.println(instance.getTwo(1, 2, 3));
        System.out.println(instance.getThree(100, 2, 3));
        System.out.println(instance.getFourth(100, 2, 3));
    }
}
