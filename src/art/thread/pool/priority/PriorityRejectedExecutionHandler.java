package art.thread.pool.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class PriorityRejectedExecutionHandler implements RejectedExecutionHandler {
    private ExecutorService poolExecutor = Executors.newSingleThreadExecutor();

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("rejectedExecution " + r);
        if (((PriorityRunnable) r).getPriority() == PriorityRunnable.LEVEL_4) {
            poolExecutor.execute(r);
        }
    }
}
