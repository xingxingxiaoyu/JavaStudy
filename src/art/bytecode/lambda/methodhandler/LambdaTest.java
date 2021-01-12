package art.bytecode.lambda.methodhandler;

public class LambdaTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("hello, lambda");
        };
        r.run();
    }
}
