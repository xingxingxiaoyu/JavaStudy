package start;

import java.util.List;

public class StartTimeTest {
    public static void main(String[] args) {

    }

    /**
     * 不考虑任务的依赖关系，计算执行这些任务的耗时
     *
     * @param taskList
     * @param threadNumber
     * @return
     */
    private int getElapsedTime(List<Task> taskList, int threadNumber) {
        //记录每个线程执行的任务耗时
        int[] threadTimes = new int[threadNumber];
        for (int i = 0; i < taskList.size(); i++) {
            int minIndex = getMinIndex(threadTimes);
            threadTimes[minIndex] = threadTimes[minIndex] + taskList.get(i).getElapsedTime();
        }
        return threadTimes[getMaxIndex(threadTimes)];
    }

    private int getMinIndex(int[] threadTimes) {
        int result = 0;
        for (int i = 1; i < threadTimes.length; i++) {
            if (threadTimes[i] < threadTimes[result]) {
                result = i;
            }
        }
        return result;
    }

    private int getMaxIndex(int[] threadTimes) {
        int result = 0;
        for (int i = 1; i < threadTimes.length; i++) {
            if (threadTimes[i] > threadTimes[result]) {
                result = i;
            }
        }
        return result;
    }
}
