package common;

public class BaseNode<V> {
    private V value;


    public BaseNode(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BaseNode{" +
                "value=" + value +
                '}';
    }

    protected String toNodeString(int index) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("node index ").append(index).append(", value is ").append(value).append("\r\n");
        return stringBuilder.toString();
    }
}
