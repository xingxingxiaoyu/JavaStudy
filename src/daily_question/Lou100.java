package daily_question;

import java.util.Arrays;

//100¥�Ҳ��鼦��
public class Lou100 {
    public static void main(String[] args) {
        System.out.println(getMin());
        System.out.println(Arrays.toString(ints));
        for (int i = 1; i < ints.length; i++) {
            if (ints[i - 1] < ints[i]) {
                System.out.println(i - 1);
            }
        }

    }

    private static int[] ints = new int[101];

    private static int getMin() {
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= 100; i++) {
            int[] arrs = new int[i];
            for (int j = 0; j < i; j++) {
                //������i�����ڵ�j�����ԣ�ǰ����j����������i-j-1��
                if (j < i - j - 1) {
                    arrs[j] = 1 + ints[i - j - 1];
                } else {
                    arrs[j] = 1 + ints[j];
                }
            }
            System.out.println(Arrays.toString(arrs));

            ints[i] = min(arrs);
        }
        return ints[100];
    }

    private static int min(int[] ints) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] < min) {
                min = ints[i];
            }
        }
        return min;
    }

}
