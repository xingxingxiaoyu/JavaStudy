package art.class34.class5;

import java.io.*;

public class FileClassLoader extends ClassLoader {
    private String filePath;

    public FileClassLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(filePath + name.replace('.','\\') + ".class");
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
