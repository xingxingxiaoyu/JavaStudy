package other;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static void main(String[] args) {
        File file = new File("D:\\����ͷ��Ŀ���\\����ͷѹ����־\\OTAѹ��_����ͷOTA�����ع�ѹ��_20210207085748\\fail_logs");
        File[] files = file.listFiles();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            String s = name.substring(name.indexOf("��") + 1, name.indexOf("��"));
            integers.add(Integer.valueOf(s));
        }
        Object[] a = integers.toArray();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


}