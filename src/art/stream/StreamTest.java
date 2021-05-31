package art.stream; 
 
import java.io.*; 
 
public class StreamTest { 
    public static void main(String[] args) { 
        for (int i = 0; i < 1000; i++) { 
            try { 
                OutputStreamWriter stream = new OutputStreamWriter(new FileOutputStream("test.txt")); 
                stream.append((char) i); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
            try { 
                Thread.sleep(100); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println("" + i); 
        } 
 
    } 
} 
