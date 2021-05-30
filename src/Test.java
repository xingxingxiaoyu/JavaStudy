import java.util.*;

public class Test {
    private static volatile Test test;

    private Test() {
    }

    public static Test getInstance() {
        if (test == null) {
            synchronized (Test.class) {
                if (test == null) {
                    test = new Test();
                }
            }
        }
        return test;
    }
}

class Test2 {
    private static class Inner {
        private static Test2 test = new Test2();
    }

    private Test2() {
    }

    public static Test2 getInstance() {
        return Inner.test;
    }

    class Inner2 {
        public Inner2(Test2 test2) {

        }

    }
}

class Test3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test3().sort(new int[]{123, 34, 35435, 23432, 43, 23})));
    }

    private int[] sort(int[] array) {

        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int start, int end) {
        if (end == start) {
            return;
        }
        if (end - start == 1) {
            if (array[end] > array[start]) {
                int flag = array[start];
                array[start] = array[end];
                array[end] = flag;
            }
            return;
        }


        int key = array[start];
        int keyIndex = start;
        //start-(keyIndex-1) С��key
        //keyIndex-i  ����key
        for (int i = start + 1; i <= end; i++) {
            if (key > array[i]) {
                //key����һλ��iλ�õ�ȡ��keyindex��keyindex��ȥi
                array[keyIndex] = array[i];
                array[i] = array[keyIndex + 1];
                array[keyIndex + 1] = key;
                keyIndex++;
            }
        }
        sort(array, start, keyIndex - 1);
        sort(array, keyIndex + 1, end);

    }
}

class Test4 {

    public static class Maneger {
        public static LinkedList<Message> messageList = new LinkedList<>();
    }

    static class Message {
        public void inkove() {

        }
    }

    static class Creator {

        public void craateMessage() {
            Maneger.messageList.add(new Message() {
                @Override
                public void inkove() {
                    super.inkove();
                    System.out.println("111");
                }
            });
        }

    }

    static class Dealer {
        public void dealMessage() {
            Maneger.messageList.removeFirst().inkove();
        }
    }

    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.craateMessage();

        new Dealer().dealMessage();
    }
}

//    ��һ�� N �� N �ķ��������У�ÿ����Ԫ��������״̬���գ�0������������1����
//        ����������A��B�����꣬(xA,yA) (xB,yB)������������֮������·����
//        ������ɴ����-1
class Test5 {

    public static void main(String[] args) {

    }


    public static int getRoad(int[][] array, Point start, Point end) {
        //��¼�Ѿ��������ĵ�
        Set<Point> points = new HashSet<>();
        //��¼���ڱ����ĵ�
        Set<Point> currentPoints = new HashSet<>();
        currentPoints.add(start);
        for (int i = 0; i < array.length; i++) {

            if (currentPoints.contains(end)) {
                return i + 1;
            }
            //�ӵ�ǰ�ĵ����һ��
            step(points, currentPoints, array);
        }

        return -1;
    }

    private static void step(Set<Point> points, Set<Point> currentPoints, int[][] array) {
        currentPoints.forEach(point -> {
            //currentPoints

        });
    }


}

class Point {
    int x;
    int y;
}