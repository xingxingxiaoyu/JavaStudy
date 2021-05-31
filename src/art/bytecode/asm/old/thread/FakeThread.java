package art.bytecode.asm.old.thread; 
 
public class FakeThread implements Runnable { 
    private Runnable runnable; 
 
    @Override 
    public void run() { 
        runnable.run(); 
    } 
 
    public FakeThread(Runnable runnable) { 
        this.runnable = runnable; 
    } 
 
    private void start() { 
        AsmThreadTest.executor.execute(runnable); 
    } 
} 
