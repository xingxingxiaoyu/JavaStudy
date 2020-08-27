package other;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static void main(String[] args) {
        File file = new File("D:\\doc\\杂七杂八\\回滚\\OTA压测_摄像头OTA升级回滚压测_20200812095752\\fail_logs");
        File[] files = file.listFiles();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            String s = name.substring(name.indexOf("第") + 1, name.indexOf("次"));
            integers.add(Integer.valueOf(s));
        }
        Object[] a = integers.toArray();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }


}
