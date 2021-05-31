package art.reference; 
 
import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.lang.ref.PhantomReference; 
 
public class ReferenceTest { 
    public static void main(String[] args) { 
        StringBuilder stringBuilder = new StringBuilder(); 
        try { 
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\develop\\code\\Java\\idea\\LeetCode\\src\\art\\reference\\1")); 
            String s = null; 
            while ((s = bufferedReader.readLine()) != null) { 
                stringBuilder.append(s); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        String html = stringBuilder.toString(); 
        int from = 0; 
        for (; ; ) { 
            int indexOf = html.indexOf("data-objurl=\"", from); 
            if (indexOf <= -1) { 
                return; 
            } 
            int i1 = html.indexOf("\"", indexOf + 13); 
            System.out.println(",\"" + html.substring(indexOf + 13, i1) + "\""); 
            from = i1; 
 
        } 
    } 
} 
