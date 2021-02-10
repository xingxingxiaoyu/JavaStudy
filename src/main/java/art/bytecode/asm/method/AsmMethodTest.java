package art.bytecode.asm.method;

public class AsmMethodTest {
    public static void testPrint() {
        {
            System.out.println("testPrint");
        }
    }

    public static void testPrintResult() {
        long var1 = System.nanoTime();
        System.out.println("¿ª¹¤12");
        var1 = System.nanoTime() - var1;
        System.out.println(var1);
    }

}
