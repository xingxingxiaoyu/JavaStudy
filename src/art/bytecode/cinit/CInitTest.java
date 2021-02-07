package art.bytecode.cinit;


public class CInitTest {


    public static String a = "";
    private static CInitTest instance = new CInitTest();

    public CInitTest() {
        System.out.println("CInitTest构造方法");
    }

    static {
        System.out.println("CInitTest静态代码块");
    }

}

class Test {

    public static void main(String[] args) {
        System.out.println(CInitTest.a);

    }
}


class A {
    static {
        System.out.println("A initializing......");
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new B();
//        new A();
    }
}

class B {
    static {
        System.out.println("B initializing......");
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new A();
//        new B();
    }
}

class InitializationTest {

    public static void main(String[] a) {
        new Thread() {
            @Override
            public void run() {
                new A();
            }
        }.start();
        new B();
        System.out.println("Done.");
    }
}