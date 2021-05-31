package art.thread.pool; 
 
import java.util.concurrent.ThreadFactory; 
 
public class ClassThreadFactory implements ThreadFactory { 
    @Override 
    public Thread newThread(Runnable r) { 
        return null; 
    } 
} 
