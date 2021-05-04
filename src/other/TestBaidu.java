package other;

public class TestBaidu {
    public static void main(String[] args) {
        Node target = new Node();

        Node firstNode = target;
        Node secondNode = target;

        while (true) {
            firstNode = firstNode.next;
            if (firstNode == null) {
                System.out.println("无环");
            }
            secondNode = secondNode.next.next;
            if (secondNode == null) {
                System.out.println("无环");
            }
            if (firstNode == secondNode) {
                System.out.println("有环");
            }
        }


    }
}

class Node {
    public Node next;
}

class Instance{
    //Logger

    private volatile static Instance instance;
    private Instance(){}

    public static Instance getInstance(){
        if (instance==null){
            synchronized (Instance.class){
                if (instance==null){
                    instance=new Instance();
                }
            }
        }
        return instance;
    }
}