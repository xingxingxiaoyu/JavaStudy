package leetcode.topic_2_����֮��;

/*��������?�ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ���?����?�ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�

��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�

�����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��

ʾ����

���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
�����7 -> 0 -> 8
ԭ��342 + 465 = 807

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/add-two-numbers
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������*/
public class Topic2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(1))));
        System.out.println(new Topic2().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode curListNode = listNode;
        boolean isCarry = false;
        while (true) {
            int sum = 0;
            if (isCarry) {
                sum = getVal(l1) + getVal(l2) + 1;
            } else {
                sum = getVal(l1) + getVal(l2);
            }
            if (sum > 9) {
                curListNode.val = sum - 10;
                isCarry = true;
            } else {
                curListNode.val = sum;
                isCarry = false;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (l1 == null && l2 == null) {
                if (isCarry) {
                    curListNode.next = new ListNode(1);
                }
                break;
            }
            ListNode nextListNode = new ListNode(0);
            curListNode.next = nextListNode;
            curListNode = nextListNode;
        }
        return listNode;

    }

    private int getVal(ListNode listNode) {
        return listNode == null ? 0 : listNode.val;
    }
}
