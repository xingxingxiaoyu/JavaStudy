package art.bytecode; 
 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
 
public class Javap { 
    public static void main(String[] args) throws Throwable { 
        System.out.println(invoke("D:\\develop\\code\\Java\\idea\\LeetCode\\out\\production\\LeetCode\\art\\bytecode\\Simple.class")); 
    } 
 
    private static String invoke(String filePath) { 
        File file = new File(filePath); 
        StringBuilder stringBuilder = new StringBuilder(); 
        try { 
            byte[]bytes=new byte[65535]; 
            FileInputStream fileInputStream = new FileInputStream(file); 
            //读取魔数 
            int read = fileInputStream.read(bytes, 0, 8); 
            //读取版本号 
            //读取常量池 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return ""; 
    } 
} 
