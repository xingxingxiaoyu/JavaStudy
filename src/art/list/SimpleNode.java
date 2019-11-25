package art.list;

public class SimpleNode<T> {
    public T value;
    public SimpleNode<T> next;
    public SimpleNode<T> prep;

    public SimpleNode(T value) {
        this.value = value;
    }
}
