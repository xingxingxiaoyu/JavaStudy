package other;

import java.io.*;

public class InstallUtil {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            exec("adb install -r D:\\develop\\code\\android\\test\\MessageDispatcherTest\\app\\build\\outputs\\apk\\a" + i + "\\debug\\app-a" + i + "-debug.apk");



        }
        try {
            Thread.sleep(1000);
            exec("adb shell am broadcast -a message.test");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Process exec(final String command) {

        System.out.println("exec: " + command);

        DataOutputStream outputStream = null;
        BufferedReader successResult = null;
        BufferedReader errorResult = null;
        StringBuilder successMessage = new StringBuilder();
        StringBuilder errorMessage = new StringBuilder();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
            successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
            errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            process.waitFor();
            String s = null;
            do {
                s = successResult.readLine();
                System.out.println("exec: successResult " + s);
                successMessage.append(s).append("\r\n");
            }  while (s != null && !"".equals(s));

            do {
                s = errorResult.readLine();
                System.out.println("exec: errorMessage " + s);
                successMessage.append(s).append("\r\n");
            } while (s != null && !"".equals(s));

            System.out.println("exec:command " + command + " successMessage " + successMessage + " errorMessage " + errorMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            process.destroy();
            closeStream(outputStream);
            closeStream(successResult);
            closeStream(errorResult);
        }
        return process;
    }

    static void closeStream(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
