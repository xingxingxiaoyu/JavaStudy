package art.thread; 
 
public class ThreadDemo2 { 
 
    private  static int i; 
 
    public static void main(String[] args) { 
        System.out.println(System.currentTimeMillis()); 
        new Thread(new Runnable() { 
            @Override 
            public void run() { 
                int a = 0; 
                while (true) { 
                    i = a++; 
                    System.out.println("a " + i); 
                } 
            } 
        }).start(); 
        new Thread(new Runnable() { 
            @Override 
            public void run() { 
                while (true) { 
                    System.out.println("b =========" + i); 
                } 
            } 
        }).start(); 
    } 
} 
