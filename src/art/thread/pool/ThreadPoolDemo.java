package art.thread.pool; 
 
import java.util.concurrent.*; 
 
public class ThreadPoolDemo { 
    public static void main(String[] args) { 
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 10, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2)); 
        //        poolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { 
//            @Override 
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) { 
// 
//                System.out.println(Thread.currentThread().getName()); 
//            } 
//        }); 
//        for (int i = 0; i < 100; i++) { 
//            System.out.println("==================="); 
//            int a = i; 
//            TestBean result = new TestBean("" + a); 
//            Future<TestBean> future = poolExecutor.submit(new Runnable() { 
//                @Override 
//                public void run() { 
//                    result.setName("set " + result.getName()); 
//                    try { 
//                        Thread.sleep(1000); 
//                    } catch (InterruptedException e) { 
//                        e.printStackTrace(); 
//                    } 
//                    System.out.println(Thread.currentThread().getName() + " " + a); 
//                } 
//            }, result); 
// 
//            try { 
//                System.out.println(System.currentTimeMillis()); 
//                TestBean bean = future.get(); 
//                System.out.println(System.currentTimeMillis() + " " + bean); 
// 
//            } catch (InterruptedException e) { 
//                e.printStackTrace(); 
//            } catch (ExecutionException e) { 
//                e.printStackTrace(); 
//            } 
// 
//        } 
// 
//        TestBean bean = new TestBean("111"); 
//        TestBean bean2 = new TestBean("222"); 
//        bean = bean2 = new TestBean("333"); 
//        System.out.println(System.currentTimeMillis() + " " + bean); 
//        System.out.println(System.currentTimeMillis() + " " + bean2); 
// 
//        Executors.newCachedThreadPool(); 
//        Executors.newFixedThreadPool(10); 
//        Executors.newScheduledThreadPool(10); 
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(); 
// 
//        for (int i = 0; i < 10; i++) { 
//            int a = i; 
//            singleThreadExecutor.execute(new Runnable() { 
//                @Override 
//                public void run() { 
//                    System.out.println("newSingleThreadExecutor" + a); 
//                    throw new RuntimeException("newSingleThreadExecutor"); 
//                } 
//            }); 
//        } 
 
 
//        try { 
//            Thread.sleep(1000); 
//        } catch (InterruptedException e) { 
//            e.printStackTrace(); 
//        } 
//        System.out.println("============================"); 
// 
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1); 
// 
//        for (int i = 0; i < 10; i++) { 
//            int a = i; 
//            fixedThreadPool.execute(new Runnable() { 
//                @Override 
//                public void run() { 
//                    System.out.println("fixedThreadPool" + a); 
//                    throw new RuntimeException("fixedThreadPool"); 
//                } 
//            }); 
//        } 
 
        ScheduledExecutorService singleThreadExecutor = Executors.newScheduledThreadPool(2); 
 
        singleThreadExecutor.scheduleAtFixedRate(new Runnable() { 
            @Override 
            public void run() { 
                System.out.println("newScheduledThreadPool start " + System.currentTimeMillis()); 
                try { 
                    Thread.sleep(1000); 
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
                System.out.println("newScheduledThreadPool end " + System.currentTimeMillis()); 
 
            } 
        }, 100, 3000, TimeUnit.MILLISECONDS); 
        System.out.println("newScheduledThreadPool " + System.currentTimeMillis()); 
 
 
 
    } 
 
    private static class TestBean { 
        String name; 
 
        @Override 
        public String toString() { 
            return "TestBean{" + 
                    "name='" + name + '\'' + 
                    '}'; 
        } 
 
        public String getName() { 
            return name; 
        } 
 
        public void setName(String name) { 
            this.name = name; 
        } 
 
        public TestBean(String name) { 
            this.name = name; 
        } 
    } 
} 
