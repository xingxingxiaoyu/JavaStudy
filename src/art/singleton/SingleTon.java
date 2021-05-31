package art.singleton; 
 
public interface SingleTon { 
 
    SingleTon createInstance(); 
 
    int getImportanceLevel(); 
 
    default void release(int leavel) { 
        if (getImportanceLevel() < leavel) { 
            release(); 
        } 
    } 
 
    void release(); 
} 
