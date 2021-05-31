package art.map; 
 
import java.util.Arrays; 
import java.util.Map; 
 
public class SimpleMap { 
    private Entry<Integer, String>[] data; 
 
    public SimpleMap() { 
        this.data = new SimpleEntry[100]; 
    } 
 
    public void put(Integer key, String value) { 
        data[key] = new SimpleEntry(key, value); 
    } 
 
    public String get(Integer key) { 
        Entry<Integer, String> entry = data[key]; 
        if (entry != null) { 
            return entry.getValue(); 
        } 
        return null; 
    } 
 
} 
