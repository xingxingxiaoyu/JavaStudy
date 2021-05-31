package common; 
 
public class SingleNode<V> extends BaseNode<V> { 
 
    public SingleNode<V> next; 
 
    public SingleNode(V value) { 
        super(value); 
    } 
 
    public SingleNode(V value, SingleNode<V> next) { 
        super(value); 
        this.next = next; 
    } 
 
    @Override 
    public String toString() { 
        return "SingleNode{" + 
                "value=" + getValue() + 
                ", next=" + next.getValue() + 
                '}'; 
    } 
 
    public String toListString() { 
        StringBuilder stringBuilder = new StringBuilder(); 
        stringBuilder.append(toNodeString(0)); 
        SingleNode<V> next = this.next; 
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
