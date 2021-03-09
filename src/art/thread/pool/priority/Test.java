package art.thread.pool.priority;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    private static int num1;
    private static int num2;
    private static int num3;
    private static int num4;

    public static void main(String[] args) {
        BlockingQueue queue = new PriorityBlockingQueue(10);
        PriorityBlockingQueue priorityBlockingQueue = (PriorityBlockingQueue) queue;
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,
                5,
                100,
                TimeUnit.SECONDS,
                queue);
        PriorityRejectedExecutionHandler handler = new PriorityRejectedExecutionHandler();
        priorityBlockingQueue.setHandler(handler);
        priorityBlockingQueue.setPoolExecutor(poolExecutor);
        poolExecutor.setRejectedExecutionHandler(handler);


        Random random = new Random();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            final int value = i;
            poolExecutor.execute(new PriorityRunnable(value % 4 + 1) {
                @Override
                public void run() {
                    System.out.println("run start getPriority " + getPriority() + "\tvalue " + value);
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Test.class) {
                        switch (getPriority()) {
                            case LEVEL_1:
                                num1++;
                                break;
                            case LEVEL_2:
                                num2++;
                                break;
                            case LEVEL_3:
                                num3++;
                                break;
                            case LEVEL_4:
                                num4++;
                                break;
                        }
                    }
                    System.out.println("run end   getPriority " + getPriority() + "\tvalue " + value);

                }

                @Override
                public String toString() {
                    return super.toString() + "  value " + value;
                }
            });
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 100 == 0) {
                System.out.println("num1 " + num1 + " num2 " + num2 + " num3 " + num3 + " num4 " + num4);

            }
        }

    }
}
