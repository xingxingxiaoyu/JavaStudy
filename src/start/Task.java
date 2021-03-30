package start;

import java.util.List;

public abstract class Task implements Runnable {
    private String taskName;
    private int elapsedTime;

    public Task(int elapsedTime) {
        taskName = getClass().getName();
        this.elapsedTime = elapsedTime;
    }

    public Task(String taskName, int elapsedTime) {
        this.taskName = taskName;
        this.elapsedTime = elapsedTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public List<String> getDependList() {
        return dependList;
    }

    public Task(String taskName, int elapsedTime, List<String> dependList) {
        this.taskName = taskName;
        this.dependList = dependList;
        this.elapsedTime = elapsedTime;
    }

    private List<String> dependList;
}
