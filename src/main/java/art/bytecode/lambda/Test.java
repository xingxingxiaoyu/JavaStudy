package art.bytecode.lambda;

public class Test {
    public static void main(String[] args) {
        Jige jige = new Jige();
        long millis = System.currentTimeMillis();
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            if (jige.isFlag()) ;
        }
        System.out.println(System.currentTimeMillis() - millis);

        millis = System.currentTimeMillis();
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            jige.setFlag(true);
        }
        System.out.println(System.currentTimeMillis() - millis);


    }

    static class Jige {
        private boolean flag;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }
}
