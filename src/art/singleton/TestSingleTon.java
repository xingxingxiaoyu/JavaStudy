package art.singleton; 
 
public class TestSingleTon implements SingleTon { 
    private static TestSingleTon singleTon; 
 
    private TestSingleTon() { 
    } 
 
    @Override 
    public SingleTon createInstance() { 
        if (singleTon == null) { 
            synchronized (TestSingleTon.class) { 
                singleTon = new TestSingleTon(); 
            } 
        } 
        return singleTon; 
    } 
 
    @Override 
    public int getImportanceLevel() { 
        return 10; 
    } 
 
    @Override 
    public void release() { 
        singleTon = null; 
    } 
} 
