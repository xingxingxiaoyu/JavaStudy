package art.bytecode.asm.old.method; 
 
public class AsmMethodTest { 
    public static void testPrint() { 
        { 
            System.out.println("testPrint"); 
        } 
    } 
 
    public static void testPrintResult() { 
        long var1 = System.nanoTime(); 
        System.out.println("开工12"); 
        var1 = System.nanoTime() - var1; 
        System.out.println(var1); 
    } 
 
} 
