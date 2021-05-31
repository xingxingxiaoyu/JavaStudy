package art.bytecode.asm.old; 
 
public class AsmDemo { 
 
    private static String aString = "xuyu"; 
    private static int aInt = 1024; 
 
    public AsmDemo() { 
    } 
 
    public void testPrint(String a) throws Exception { 
        System.out.println(a); 
        aString = "xuysfhskjdf"; 
        throw new Exception(); 
 
    } 
} 
