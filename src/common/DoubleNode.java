package common;

public class DoubleNode<V> extends BaseNode<V> {

    public DoubleNode<V> prep;
    public DoubleNode<V> next;

    public DoubleNode(V value) {
        super(value);
    }

    public DoubleNode(V value, DoubleNode<V> prep, DoubleNode<V> next) {
        super(value);
        this.prep = prep;
        this.next = next;
        if (prep != null) {
            prep.next = this;
        }
        if (next != null) {
            next.prep = this;
        }
    }



    @Override
    public String toString() {
        return "BaseNode{" +
                "value=" + getValue() +
                ", prep=" + prep.getValue() +
                ", next=" + next.getValue() +
                '}';
    }

    public String toListString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toNodeString(0));
        DoubleNode<V> prep = this.prep;
        int prepIndex = 0;
        while (prep != null) {
            stringBuilder.insert(0, prep.toNodeString(--prepIndex));
            prep = prep.prep;
        }

        DoubleNode<V> next = this.next;
        int nextIndex = 0;
        while (next != null) {
            stringBuilder.append(next.toNodeString(++nextIndex));
            next = next.next;
        }
        stringBuilder.insert(0, "===============start=============\r\n");
        stringBuilder.append("===============end=============\r\n");
        return stringBuilder.toString();
    }


}
