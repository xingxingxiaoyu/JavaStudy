package art.class34.class5; 
 
import java.io.*; 
 
/** 
 * 可以选择不使用系统已经有了的类 
 */ 
public class FileClassLoader extends ClassLoader { 
    private String filePath; 
 
    public FileClassLoader(String filePath) { 
        this.filePath = filePath; 
    } 
 
    public FileClassLoader(String filePath, ClassLoader parent) { 
        super(parent); 
        this.filePath = filePath; 
    } 
 
//    @Override 
//    public Class<?> loadClass(String name) throws ClassNotFoundException { 
//        Class<?> c = findBootstrapClassOrNull(name); 
//        return findClass(name); 
//    } 
 
    @Override 
    protected Class<?> findClass(String name) { 
        File file = new File(filePath + name.replace('.', '\\') + ".class"); 
        System.out.println("findClass "+file.getAbsolutePath()); 
        try { 
            FileInputStream fis = new FileInputStream(file); 
            byte[] bytes = new byte[1024]; 
            int length = fis.read(bytes); 
            return defineClass(name, bytes, 0, length); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return null; 
    } 
} 
