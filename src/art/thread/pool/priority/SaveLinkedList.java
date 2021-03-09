package art.thread.pool.priority;

import java.util.LinkedList;

public class SaveLinkedList<T> extends LinkedList<T> {
    @Override
    public T removeFirst() {
        try {
            return super.removeFirst();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public T removeLast() {
        try {
            return super.removeLast();
        } catch (Exception e) {
            return null;
        }
    }
}
