package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//贪心算法
//选择出最大的兼容活动组
public class ActivityChoice {
    public static void main(String[] args) {
        int[] s = new int[]{1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = new int[]{4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        System.out.println(Arrays.toString(getList(s, f).toArray()));


    }

    private static List<Integer> getList(int[] s, int[] f) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);

        int currentIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= f[currentIndex]) {
                currentIndex = i;
                integers.add(i + 1);
            }
        }
        return integers;

    }
}
