package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
������˵ߣ����·���ŵ����ж��� talk is cheap,show me your code     ����һ��������ɫ����ɫ����ɫ��һ��?n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�

�����У�����ʹ������ 0��?1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��

ע��:
����ʹ�ô�����е����������������⡣

ʾ��:

����: [2,0,2,1,1,0]
���: [0,0,1,1,2,2]
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
