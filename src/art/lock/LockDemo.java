package art.lock; 
 
import java.util.concurrent.locks.ReentrantLock; 
 
public class LockDemo { 
    private static int num = 100; 
 
    public static void main(String[] args) { 
 
        ReentrantLock reentrantLock = new ReentrantLock(); 
 
        for (int i = 0; i < 4; i++) { 
            new Thread() { 
                @Override 
                public void run() { 
                    while (true) { 
                        reentrantLock.lock(); 
                        if (num > 0) { 
                            try { 
                                Thread.sleep(10); 
                            } catch (InterruptedException e) { 
                                e.printStackTrace(); 
                            } 
                            num--; 
                            System.out.println(Thread.currentThread().getName() + " " + num); 
                        } else { 
                            return; 
                        } 
                        reentrantLock.unlock(); 
                    } 
                } 
            }.start(); 
        } 
 
    } 
} 
