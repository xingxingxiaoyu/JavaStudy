package other;

import java.io.*;

public class TestDialog {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\DELL3620\\Downloads\\2861_17-48-17\\log\\dialogdismiss.txt")));
            int number = 0;
            int lastTime = 0;
            int currentTime = 0;
            String line = null;
            while ((line = reader.readLine()) != null) {

                number++;
                int i = line.indexOf(":", line.indexOf(":") + 1);
                String substring = line.substring(i + 4, i + 6);
                currentTime = Integer.parseInt(substring);
                if (currentTime - lastTime > 15 || (currentTime - lastTime < 0 && currentTime - lastTime + 60 > 15)) {
                    System.out.println("main: " + line);
                    System.out.println("main: time" + (currentTime - lastTime < 0 ? currentTime - lastTime + 60 : currentTime - lastTime));
                    System.out.println("error: number " + number + " currentTime " + currentTime + " lastTime " + lastTime);

                } else if ((currentTime - lastTime > 0 && currentTime - lastTime < 5) || (currentTime - lastTime < 0 && currentTime - lastTime + 60 < 5)) {
                    System.out.println("main: " + line);
                    System.out.println("main: time" + (currentTime - lastTime < 0 ? currentTime - lastTime + 60 : currentTime - lastTime));
                    System.out.println("error2: number " + number + " currentTime " + currentTime + " lastTime " + lastTime);
                }
                lastTime = currentTime;
                System.out.println("main: " + substring);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
