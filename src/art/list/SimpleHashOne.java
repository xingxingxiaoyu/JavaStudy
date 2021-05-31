package art.list; 
 
public class SimpleHashOne { 
    private int[] data = new int[100]; 
 
    public void put(int i) { 
        data[i - 1] = i; 
    } 
 
    public boolean get(int i) { 
        return data[i] > 0; 
    } 
 
} 
