package art.thread; 
 
public class SleepAndWait { 
    public static void main(String[] args) { 
        SleepAndWait sleepAndWait = new SleepAndWait(); 
        for (int i = 0; i < 10; i++) { 
            new Thread(new Runnable() { 
                @Override 
                public void run() { 
                    sleepAndWait.sleepTest(); 
                } 
            }).start(); 
        } 
 
        for (int i = 0; i < 10; i++) { 
            new Thread(new Runnable() { 
                @Override 
                public void run() { 
                    sleepAndWait.waitTest(); 
                } 
            }).start(); 
        } 
 
        try { 
            Thread.sleep(20000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
 
 
    } 
 
    private long time = System.currentTimeMillis(); 
    private Object sleepLock = new Object(); 
 
    private void sleepTest() { 
        synchronized (sleepLock) { 
            try { 
                Thread.sleep(1000); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println("sleepTest " + (System.currentTimeMillis() - time)); 
        } 
    } 
 
    private Object waitLock = new Object(); 
 
    private void waitTest() { 
        synchronized (waitLock) { 
            try { 
                waitLock.wait(1000); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println("waitTest" + (System.currentTimeMillis() - time)); 
        } 
    } 
} 
