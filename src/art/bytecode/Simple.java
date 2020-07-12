package art.bytecode;

public class Simple
        extends BaseSimple implements ISimple {
    public final static String sField = "testStaticFinalString";
    public final String sField2 = "testFinalString";
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

        printAddResult1("");
        return b;
    }

    @TestAnnotation
    public static void printAddResult1(@TestAnnotation String s) {
        int i = new Simple().add(10, 20);
        System.out.println(i);
    }

}
