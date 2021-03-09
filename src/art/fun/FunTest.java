package art.fun;

import java.util.ArrayList;
import java.util.function.Function;

public class FunTest {
    public static void main(String[] args) {
        List<Integer> integerList = new List<>(new ArrayList<>());
        List<String> map = integerList.map(Object::toString);
    }
}

class List<T> {
    private ArrayList<T> list = new ArrayList<>();

    public List(ArrayList<T> list) {
        this.list = list;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    public <R> List<R> map(Function<T, R> map) {
        List<R> rList = new List<>(new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            rList.list.add(map.apply(list.get(i)));
        }
        return rList;
    }
}