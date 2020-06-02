package art.bytecode;

public class Simple extends BaseSimple implements ISimple {
    private String s;

    public int add(int a, int b) {
        return a + b;
    }
}
