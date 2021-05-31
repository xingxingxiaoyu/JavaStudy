package art.map; 
 
public class SimpleMap2 { 
    private Entry<Integer, String>[] data; 
 
    public SimpleMap2() { 
        this.data = new SimpleEntry[100]; 
    } 
 
    public void put(Integer key, String value) { 
        int index = hash(key); 
        Entry<Integer, String> entry = null; 
        while ((entry = data[index]) != null 
                && !entry.getKey().equals(key)) { 
            index = getNextIndex(index); 
        } 
        //这个时候要么data[index]为空，要么data[index]保存的值key等于传入的key 
        data[index] = new SimpleEntry(key, value); 
    } 
 
    public String get(Integer key) { 
        int index = hash(key); 
        Entry<Integer, String> entry = null; 
        while ((entry = data[index]) != null) { 
            if (entry.getKey().equals(key)){ 
                return entry.getValue(); 
            } 
            index = getNextIndex(index); 
        } 
        return null; 
    } 
 
    private int hash(Integer key) { 
        return key % 100; 
    } 
 
    private int getNextIndex(int index) { 
        return index + 1; 
    } 
 
} 
