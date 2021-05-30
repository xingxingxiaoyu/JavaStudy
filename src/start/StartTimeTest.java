package start;

import java.util.List;

public class StartTimeTest {
    public static void main(String[] args) {
        String a="";
        for (int i = 0; i < 100; i++) {
            a+=i;
        }
        System.out.println("main: "+a);
    }

    /**
     * ?????????????????????????????§»???????
     *
     * @param taskList
     * @param threadNumber
     * @return
     */
    private int getElapsedTime(List<Task> taskList, int threadNumber) {
        //???????????§Ö???????
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
