package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
二话不说撸出三路快排的能有多少 talk is cheap,show me your code     给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 0, 1, 2, 2, 2, 1, 1, 0, 0, 0, 1, 2})));
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 0, 0, 1, 2, 0, 0, 1, 2, 0, 0, 1, 2, 0, 2, 2, 1, 1, 0, 0, 0, 1, 2})));
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 0, 1, 2, 2, 2, 1, 1, 0, 0, 0, 1, 2, 0, 1, 2, 0, 1, 2, 2, 2, 1, 1, 0, 0, 0, 1, 2, 0, 1, 2, 0, 1, 2, 2, 2, 1, 1, 0, 0, 0, 1, 2})));
        System.out.println(Arrays.toString(sort(new int[]{0, 0, 1, 2, 0})));
        System.out.println(Arrays.toString(sort(new int[]{0, 0, 1, 2, 0, 0, 0, 1, 2, 0, 0, 0, 1, 2, 0, 0, 0, 1, 2, 0, 0, 0, 1, 2, 0})));
    }

    private static int[] sort(int[] array) {
        int oneIndex = -1;
        int twoIndex = array.length - 1;
        for (int i = 0; i < twoIndex; i++) {
            switch (array[i]) {
                case 0:
                    if (oneIndex > 0) {
                        array[oneIndex] = 0;
                        array[i] = 1;
                        oneIndex++;
                    }
                    break;
                case 1:
                    if (oneIndex >= 0) {
                        break;
                    } else {
                        oneIndex = i;
                    }
                    break;
                case 2:
                    while (array[twoIndex] == 2) {
                        twoIndex--;
                    }
                    array[i] = array[twoIndex];
                    array[twoIndex] = 2;
                    i--;
                    break;
            }
//            System.out.println(i + " " + oneIndex);
//            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}
