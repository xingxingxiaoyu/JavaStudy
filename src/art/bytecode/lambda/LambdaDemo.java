package art.bytecode.lambda;

public class LambdaDemo {
    public void test() {
        printBy(1, 1, () -> System.out.println("aaa"), "");
    }

    public void printBy(int b, int a, Testinterface testinterface, String s) {
        testinterface.print();
    }

    public static void main(String[] args) {
        String data=String.format("100的一半是：%d", 100/2);

        System.out.println(data);
        System.out.printf("100的一半是：%d %n", 100 / 2);
    }
}

interface Testinterface {
    void print();
}
