package art.thread;

public class ThreadDemo {

    private static Person person = new Person(400);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    i++;
                    person.setI(i);
                    System.out.println("a " + person.getI());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("b =======" + person.getI());
                }
            }
        }).start();
    }

    public static class Person {
        private Person person;
        private int count;

        public Person(int count) {
            if (count > 0) {
                person = new Person(count - 1);
                this.count = count;
            } else {
                this.count = count;
            }
        }

        private int i;

        public int getI() {
            return person == null ? i : person.getI();
        }

        public void setI(int i) {
            if (person == null) {
                this.i = i;
            } else {
                person.setI(i);
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "person=" + person +
                    ", count=" + count +
                    ", i=" + i +
                    '}';
        }
    }
}
