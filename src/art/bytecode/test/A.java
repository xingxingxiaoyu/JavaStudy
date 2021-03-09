package art.bytecode.test;

public class A {

    public static void main(String[] args) {
        B b = new A.B();

    }


    private static class B {
        private int i;

        public int getI() {
            return i + new C().i;
        }
    }

    private static class C {
        private int i;

    }
}


