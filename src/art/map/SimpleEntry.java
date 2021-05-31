package art.map; 
 
public class SimpleEntry implements Entry<Integer,String> { 
    private Integer key; 
    private String value; 
 
    public SimpleEntry() { 
    } 
 
    public SimpleEntry(Integer key, String value) { 
        this.key = key; 
        this.value = value; 
    } 
 
    @Override 
    public Integer getKey() { 
        return key; 
    } 
 
    @Override 
    public String getValue() { 
        return value; 
    } 
 
    @Override 
    public String toString() { 
        return "SimpleEntry{" + 
                "key=" + key + 
                ", value='" + value + '\'' + 
                '}'; 
    } 
} 
