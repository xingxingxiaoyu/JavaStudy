package art.thread.pool.priority;

public abstract class PriorityRunnable implements Runnable {
    public static final int LEVEL_1 = 1;
    public static final int LEVEL_2 = 2;
    public static final int LEVEL_3 = 3;
    public static final int LEVEL_4 = 4;
    private int priority = 1;

    public int getPriority() {
        return priority;
    }

    public PriorityRunnable(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PriorityRunnable{" +
                "priority=" + priority +
                '}';
    }
}
