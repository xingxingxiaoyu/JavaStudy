package art.list;

public class Util {
    private void add(SimpleNode<String> node, String str) {
        if (node == null)
            return;
        //不考虑链表有环
        while (node.next != null) {
            node = node.next;
        }
        SimpleNode<String> next = new SimpleNode<>(str);
        node.next = next;
        next.prep = node;
    }

    private void remove(SimpleNode<String> node, int index) {


    }

    private void search(SimpleNode<String> node, int index) {

    }


}
