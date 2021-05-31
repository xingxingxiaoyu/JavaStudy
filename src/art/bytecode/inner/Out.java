package art.bytecode.inner; 
 
public class Out { 
    public static void main(String[] args) { 
        int i = 0; 
        new Thread() { 
            @Override 
            public void run() { 
                try { 
                    Thread.sleep(10); 
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
                System.out.println(i); 
            } 
        }.start(); 
//        i = 10; 
 
        int a = 0; 
        new MyThread(a) { 
            @Override 
            public void run() { 
                try { 
                    Thread.sleep(10); 
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
                System.out.println(a); 
            } 
        }.start(); 
//        a = 10; 
    } 
 
    static class MyThread extends Thread { 
        private int a; 
 
        public MyThread(int a) { 
            this.a = a; 
        } 
    } 
} 
