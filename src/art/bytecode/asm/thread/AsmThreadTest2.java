package art.bytecode.asm.thread;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsmThreadTest2 {

    private static Executor executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run: name " + Thread.currentThread().getName() + " i " + finalI);
                }
            });
        }
    }


}
