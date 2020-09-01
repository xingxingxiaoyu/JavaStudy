package other;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public class Test {
    //    public static void main(String[] args) {
////        testA();
////        testB();
//        try {
//            String aa_aa = URLEncoder.encode("aa aa", "utf-8");
//            String decode = URLDecoder.decode(aa_aa, "utf-8");
//            System.out.println(aa_aa);
//            System.out.println(decode);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void testA() {
//        int i = 100;
//        int j = 200;
//        boolean b;
//        long l = System.currentTimeMillis();
//        for (long k = 0; k < 1000_000_000; k++) {
//            i++;
//            b = i > j;
//        }
//        System.out.println(System.currentTimeMillis() - l);
//    }
//
//    private static void testB() {
//        int i = 100;
//        int j = 0;
//        boolean b;
//        long l = System.currentTimeMillis();
//        for (long k = 0; k < 1000_000_000; k++) {
//            i++;
//            b = false;
//            j = i;
//        }
//        System.out.println(System.currentTimeMillis() - l);
//    }
//    public static void main(String[] args) {
//        a();
//    }
//
//    private static void a() {
//        RuntimeException runtimeException = new RuntimeException("");
//
//        System.out.println(runtimeException.getClass().getName());
//        System.out.println(Arrays.toString(runtimeException.getStackTrace()));
//    }

    private static void dealLocalMessage(String data) {
        try {

            if (data == null) {
                return;
            }
            if (data.contains("clear")) {
            } else {
                int logIndex = data.indexOf("log");
                if (logIndex >= 0) {
                    int time = Integer.parseInt(data.substring(logIndex + 4));
                    System.out.println(time);

                }
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        dealLocalMessage("log:10");
    }
}
