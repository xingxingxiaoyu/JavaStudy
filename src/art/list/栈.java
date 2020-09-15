package art.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 栈<T> {
    private List<T> list = new LinkedList<>();

    public void 入栈(T t) {
        list.add(t);
    }

    public T 出栈() {
        return list.remove(list.size() - 1);
    }
}

class 队列<T> {
    private List<T> list = new LinkedList<>();

    public void 入队(T t) {
        list.add(t);
    }

    public T 出队() {
        return list.remove(0);
    }
}
