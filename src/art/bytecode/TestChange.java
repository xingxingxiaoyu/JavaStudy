package art.bytecode; 
 
public class TestChange { 
 
    public static void main(String[] args) { 
        new TestChange().add(1, 2); 
    } 
 
    public int add(int a, int b) { 
        //鏉′欢缂栬瘧 
        if (true) 
            throw new RuntimeException(); 
        int i = a + b; 
        return i; 
    } 
 
 
    public int add2(int a, int b) { 
        System.out.println("a" + a + "b" + b); 
        int i = a + b; 
        return i; 
    } 
} 
