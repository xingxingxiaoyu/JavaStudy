package art.proxy.demo;

public class Test {
    public static void main(String[] args) {
        int i = 0;

        System.out.println(getA(i) + getB(i) + getC(i));
    }

    public static int getA(int i) {
        System.out.println("getA");

        return i;
    }

    public static int getB(int i) {
        System.out.println("getB");

        return i;
    }

    public static int getC(int i) {
        System.out.println("getC");

        return i;
    }
}
