package art.bytecode;

public class Simple
        extends BaseSimple implements ISimple {
    public final static String sField = "12435463";
    public final String sField2 = "dfghksfdgj";
    private BaseSimple simple;
    private int anInt;

    public int add(int a, int b) {
        if (a < 0) {
            System.out.println(a);
            return 0;
        }
        for (int i = 0; i < a; i++) {
            b = b + i;
        }
        try {
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        printAddResult1();
        printAddResult2();
        printAddResult3();
        printAddResult4();
        return b;
    }

    public static void printAddResult1() {
        int i = new Simple().add(10, 20);
        System.out.println(i);
    }

    protected static void printAddResult2() {
        int i = new Simple().add(10, 20);
        System.out.println(i);
    }

    static void printAddResult3() {
        int i = new Simple().add(10, 20);
        System.out.println(i);
    }

    private static void printAddResult4() {
        int i = new Simple().add(10, 20);
        System.out.println(i);
    }
}
