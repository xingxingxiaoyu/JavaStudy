package other;

public class MemoryTest {
    private int a = 12;
    private String str = "��ѷ�";

    private static int aStatic = 124;

    public static void main(String[] args) {
        int b = 13;
        new MemoryTest().a = b;

        new MemoryTest().foo(b);
        new MemoryTest().foo(aStatic);

        new MemoryTest().foo(xujiafeng);
    }

    static String xujiafeng = "��ѷ�";


    private void foo(int param) {
        param = 1000;
    }

    private void foo(String paramString) {
        paramString = "1000";
    }
}
