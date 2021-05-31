package art.thread.deadlock; 
 
public class DeadLock { 
    public static void main(String[] args) { 
 
        new Thread() { 
            @Override 
            public void run() { 
                synchronized (lock1){ 
                    System.out.println("run: thread1 start"); 
 
                    try { 
                        sleep(1000); 
                    } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                    } 
                    synchronized (lock2){ 
 
                        System.out.println("run: thread1"); 
 
                    } 
                } 
            } 
        }.start(); 
 
        new Thread() { 
            @Override 
            public void run() { 
                synchronized (lock2){ 
                    System.out.println("run: thread2 start"); 
 
                    try { 
                        sleep(1000); 
                    } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                    } 
                    synchronized (lock1){ 
 
                        System.out.println("run: thread2"); 
 
                    } 
                } 
            } 
        }.start(); 
    } 
 
    private static Object lock1 = new Object(); 
    private static Object lock2 = new Object(); 
} 
