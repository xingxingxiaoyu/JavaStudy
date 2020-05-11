package art.class34;

import java.io.Serializable;

public class Class3 implements Serializable, Cloneable {
    private int num = 1;

    public int add(int i) {
        int j = 10;
        num = num + i;
        return num;
    }
}