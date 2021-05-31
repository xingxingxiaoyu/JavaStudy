package art.thread.time; 
 
import java.util.ArrayList; 
import java.util.concurrent.ExecutionException; 
import java.util.concurrent.FutureTask; 
import java.util.concurrent.RunnableFuture; 
 
public class ThreadTime { 
 
    public static void main(String[] args) { 
        ArrayList<FutureTask> futureTasks = new ArrayList<>(); 
        long startTime = System.currentTimeMillis(); 
        for (int j = 0; j < 500; j++) { 
            FutureTask<Object> futureTask = new FutureTask<>(new Runnable() { 
                @Override 
                public void run() { 
                    long startTime = System.currentTimeMillis(); 
 
                    for (int i = 0; i < 10; i++) { 
                        System.out.println("run: " + Thread.currentThread().getName() + " " + i); 
                        try { 
                            Thread.sleep(100); 
                        } catch (InterruptedException e) { 
                            e.printStackTrace(); 
                        } 
                    } 
                    System.out.println("run: " + Thread.currentThread().getName() + " wall time " + (System.currentTimeMillis() - startTime)); 
                } 
            }, null); 
            Thread thread = new Thread(futureTask); 
            thread.start(); 
            futureTasks.add(futureTask); 
        } 
        for (int i = 0; i < futureTasks.size(); i++) { 
            try { 
                Object o = futureTasks.get(i).get(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } catch (ExecutionException e) { 
                e.printStackTrace(); 
            } 
        } 
        System.out.println("main: " + Thread.currentThread().getName() + " all time " + (System.currentTimeMillis() - startTime)); 
 
        System.out.println("main: " + Runtime.getRuntime().availableProcessors()); 
 
    } 
} 
