package leetcode.topic_2_两数之和;

/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
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
