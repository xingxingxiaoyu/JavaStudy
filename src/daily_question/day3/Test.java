package daily_question.day3;

public class Test {
    public static void main(String[] args) {

        IntegerNode list = new IntegerNode(0);
        IntegerNode prep = list;
        IntegerNode ringStart = null;
        for (int i = 1; i < 100; i++) {
            IntegerNode node = new IntegerNode(i);
            prep.next = node;
            prep = node;
            if (i == 93) {
                ringStart = node;
            }
            if (i == 99) {
                node.next = ringStart;
            }
        }
        System.out.println(hasRing(list));


    }

    private static boolean hasRing(IntegerNode list) {
        boolean result = false;
        IntegerNode one = list;
        IntegerNode two = list;
        IntegerNode meetingPoint = null;

        while (two != null) {
            one = (IntegerNode) one.next;
            two = (IntegerNode) two.next;
            if (two != null) {
                two = (IntegerNode) two.next;
            }
            if (one == two) {
                result = true;
                meetingPoint = one;
                System.out.println("交汇点：" + one.getValue());
                break;
            }
        }
        //计算环的第一个点
        if (result) {
            one = meetingPoint;
            two = list;
            while (one != two) {
                one = (IntegerNode) one.next;
                two = (IntegerNode) two.next;
            }
            System.out.println("环的第一个点：" + one.getValue());
            int count = 1;
            two = (IntegerNode) two.next;
            while (one != two) {
                two = (IntegerNode) two.next;
                count++;
            }
            System.out.println("环的长度是" + count);

        }
        return result;
    }
}
