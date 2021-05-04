package leetcode.topic_2_两数之和;

public class DataNode {
    private int value;
    public DataNode next;
    public DataNode prep;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DataNode getNext() {
        return next;
    }

    public void setNext(DataNode next) {
        this.next = next;
    }

    public DataNode getPrep() {
        return prep;
    }

    public void setPrep(DataNode prep) {
        this.prep = prep;
    }

    public DataNode(int value, DataNode next, DataNode prep) {
        this.value = value;
        this.next = next;
        this.prep = prep;
    }
}
