package leetcode.topk;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class TopK {
    public static void main(String[] args) {
//        createNumber(1000_000_0);
        getMax(100);
    }

    private static void getMax(int i) {
        long startTime = System.nanoTime();
        PriorityQueue<Long> longs = new PriorityQueue<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String s = null;
            while ((s = reader.readLine()) != null) {
                Long value = Long.valueOf(s);
                longs.add(value);
                if (longs.size() > i) {
                    longs.poll();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("100 take time :" + (System.nanoTime() - startTime));
        System.out.println(Arrays.toString(longs.toArray()));
    }

    private static void createNumber(int count) {
        Random random = new Random();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
            for (int i = 0; i < count; i++) {
                fileOutputStream.write(String.valueOf(random.nextLong()).getBytes());
                fileOutputStream.write("\r\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
