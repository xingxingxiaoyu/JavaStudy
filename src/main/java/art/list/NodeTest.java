package art.list;

import common.SingleNode;

public class NodeTest {

    public static void main(String[] args) {
        SingleNode<String> aaa = new SingleNode<>("aaa", new SingleNode<>("bbb", new SingleNode<>("ccc", new SingleNode<>("ddd"))));
        System.out.println("main: " + turnNode(aaa).toListString());
    }

    public static SingleNode<String> turnNode(SingleNode<String> targetNode) {
        SingleNode<String> newNode = null;
        SingleNode<String> oldNode = targetNode;
        while (true) {
            if (oldNode == null)
                return newNode;
            SingleNode<String> currentNode = oldNode;
            oldNode = oldNode.next;
            currentNode.next = newNode;
            newNode = currentNode;
        }
    }
}

