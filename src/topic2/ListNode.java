package topic2;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val) + " " + (next != null ? next.toString() : "");
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
