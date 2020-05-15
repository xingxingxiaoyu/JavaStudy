package other;

public class Test {
    public static void main(String[] args) {
        testA();
        testB();
    }

    private static void testA() {
        int i = 100;
        int j = 200;
        boolean b;
        long l = System.currentTimeMillis();
        for (long k = 0; k < 1000_000_000; k++) {
            i++;
            b = i > j;
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    private static void testB() {
        int i = 100;
        int j = 0;
        boolean b;
        long l = System.currentTimeMillis();
        for (long k = 0; k < 1000_000_000; k++) {
            i++;
            b = false;
            j = i;
        }
        System.out.println(System.currentTimeMillis() - l);
    }
}
