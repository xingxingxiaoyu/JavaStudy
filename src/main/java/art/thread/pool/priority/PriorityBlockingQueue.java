package art.thread.pool.priority;

import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static art.thread.pool.priority.PriorityRunnable.*;

public class PriorityBlockingQueue extends BlockingQueueAdapter<PriorityRunnable> {

    private final Object lock = new Object();

    private int max;
    private PriorityRejectedExecutionHandler handler;
    private ThreadPoolExecutor poolExecutor;

    public PriorityBlockingQueue(int max) {
        this.max = max;
    }

    public PriorityRejectedExecutionHandler getHandler() {
        return handler;
    }

    public void setHandler(PriorityRejectedExecutionHandler handler) {
        this.handler = handler;
    }

    public void setPoolExecutor(ThreadPoolExecutor poolExecutor) {
        this.poolExecutor = poolExecutor;
    }

    private final LinkedList<PriorityRunnable> levelList1 = new SaveLinkedList<>();
    private final LinkedList<PriorityRunnable> levelList2 = new SaveLinkedList<>();
    private final LinkedList<PriorityRunnable> levelList3 = new SaveLinkedList<>();
    private final LinkedList<PriorityRunnable> levelList4 = new SaveLinkedList<>();

    @Override
    public boolean offer(PriorityRunnable e) {
        synchronized (lock) {
            switch (e.getPriority()) {
                case LEVEL_1:
                    if (size() < max) {
                        levelList1.add(e);
                    } else {
                        handler.rejectedExecution(e, poolExecutor);
                    }
                    return true;
                case LEVEL_2:
                    if (size() < max) {
                        levelList2.add(e);
                        return true;
                    } else {
                        return false;
                    }
                case LEVEL_3:
                    if (size() < max) {
                        levelList3.add(e);
                        return true;
                    } else {
                        if (levelList1.size() > 0) {
                            handler.rejectedExecution(levelList1.removeFirst(), poolExecutor);
                            levelList3.add(e);
                            return true;
                        }
                        return false;
                    }
                case LEVEL_4:
                    if (size() < max) {
                        levelList4.add(e);
                        return true;
                    } else {
                        if (levelList1.size() > 0) {
                            handler.rejectedExecution(levelList1.removeFirst(), poolExecutor);
                            levelList4.add(e);
                            return true;
                        }
                        return false;
                    }

            }
        }
        return super.offer(e);
    }

    @Override
    public PriorityRunnable take() throws InterruptedException {
        synchronized (lock) {
            if (size() > 0) {
                PriorityRunnable priorityRunnable = levelList4.removeFirst();
                if (priorityRunnable != null)
                    return priorityRunnable;
                priorityRunnable = levelList3.removeFirst();
                if (priorityRunnable != null)
                    return priorityRunnable;
                priorityRunnable = levelList2.removeFirst();
                if (priorityRunnable != null)
                    return priorityRunnable;
                priorityRunnable = levelList1.removeFirst();
                if (priorityRunnable != null)
                    return priorityRunnable;
            } else {
                lock.wait();
            }
        }
        return super.take();
    }

    @Override
    public PriorityRunnable poll(long timeout, TimeUnit unit) throws InterruptedException {
        synchronized (lock) {
            if (size() > 0) {
                PriorityRunnable priorityRunnable = levelList4.removeFirst();
                if (priorityRunnable != null)
                    return priorityRunnable;
                priorityRunnable = levelList3.removeFirst();
                if (priorityRunnable != null)
                    return priorityRunnable;
                priorityRunnable = levelList2.removeFirst();
                if (priorityRunnable != null)
                    return priorityRunnable;
                priorityRunnable = levelList1.removeFirst();
                if (priorityRunnable != null)
                    return priorityRunnable;
            } else {
                long millis = unit.toMillis(timeout);
                lock.wait(millis);
            }
        }
        return super.poll(timeout, unit);
    }

    @Override
    public int size() {
        return levelList1.size() + levelList2.size() + levelList3.size() + levelList4.size();
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof PriorityRunnable) {
            PriorityRunnable e = (PriorityRunnable) o;
            synchronized (lock) {
                switch (e.getPriority()) {
                    case LEVEL_1:
                        return levelList1.remove(e);
                    case LEVEL_2:
                        return levelList2.remove(e);
                    case LEVEL_3:
                        return levelList3.remove(e);
                    case LEVEL_4:
                        return levelList4.remove(e);
                }
            }
        }
        return super.remove(o);
    }

}
