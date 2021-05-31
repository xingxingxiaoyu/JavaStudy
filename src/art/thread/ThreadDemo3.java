package art.thread; 
 
import java.util.Arrays; 
 
public class ThreadDemo3 { 
 
    public static void main(String[] args) { 
        Thread thread = new Thread(new Runnable() { 
            @Override 
            public void run() { 
                a(); 
            } 
        }); 
        thread.start(); 
        for (int i = 0; i < 10; i++) { 
            try { 
                Thread.sleep(400); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println("main: " + Arrays.toString(thread.getStackTrace())); 
        } 
    } 
 
    public static void a() { 
        try { 
            Thread.sleep(1000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        b(); 
    } 
 
    public static void b() { 
        try { 
            Thread.sleep(1000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        c(); 
    } 
 
    public static void c() { 
        try { 
            Thread.sleep(1000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        d(); 
    } 
 
    public static void d() { 
        try { 
            Thread.sleep(1000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
    } 
} 
