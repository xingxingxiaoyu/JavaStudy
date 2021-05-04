package leetcode;

//��תint
public class Topic190 {
    public static void main(String[] args) {

        System.out.println("main: " + turnInt(1));
        System.out.println("main: " + turnInt(0xffffffff));
        System.out.println("main: " + turnInt(2));
        System.out.println("main: " + turnInt(43261596));
        System.out.println("main: " + turnInt(1));
    }

    private static int turnInt(int number) {
        System.out.println("turnInt: " + Integer.toHexString(number));
        int result = 0;
        int flag = 1;
        for (int i = 0; i < 32; i++) {
            //��ȡ��ǰλ������i=0��ʱ���ȡ�������λ��
            int currentPos = flag & number;
            //�Ƶ�Ŀ�����ֵ�λ��
            if (31 - i * 2 > 0) {
                currentPos = currentPos << (31 - i * 2);
            } else {
                currentPos = currentPos >>> -(31 - i * 2);
            }
            //�ŵ��������
            result = result | currentPos;
//            System.out.println("turnInt: i " + i + " result " + Integer.toHexString(result));
//            System.out.println("turnInt: i " + i + " currentPos " + Integer.toHexString(currentPos));
//            System.out.println("turnInt: i " + i + " flag " + Integer.toHexString(flag));

            flag <<= 1;
        }
        System.out.println("main: " + Integer.toBinaryString(number));
        System.out.println("main: " + Integer.toBinaryString(result));

        return result;
    }
}
