package other;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

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

//    private static void dealLocalMessage(String data) {
//        try {
//
//            if (data == null) {
//                return;
//            }
//            if (data.contains("clear")) {
//            } else {
//                int logIndex = data.indexOf("log");
//                if (logIndex >= 0) {
//                    int time = Integer.parseInt(data.substring(logIndex + 4));
//                    System.out.println(time);
//
//                }
//            }
//        } catch (Exception e) {
//        }
//    }
//
//    public static void main(String[] args) {
//        dealLocalMessage("log:10");
//    }

    public static void main(String[] args) {
//        System.out.println(Integer.toHexString(Float.floatToIntBits(-3.2237332f)));

//        HashMap<Object, Object> hashMap = new HashMap<>();
//        hashMap.put(1, 1);
//        hashMap.put(2, 5);
//        hashMap.put(8, 123);
//        hashMap.put(1, 123423);
//        Iterator<Object> iterator = hashMap.values().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        int n = 1000;
//        double sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += 1.0 / n * (i * 1.0 / n);
//        }
//        System.out.println(sum);
        System.out.println(Integer.MAX_VALUE / 1000 / 3600 / 24);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        for (int m = 0; m < 5; m++) {
                            for (int n = 0; n < 5; n++) {
                                System.out.println(String.valueOf(i + 1) +
                                        String.valueOf(j + 1) +
                                        String.valueOf(k + 1) +
                                        String.valueOf(l + 1) +
                                        String.valueOf(m + 1) +
                                        String.valueOf(n + 1));

                            }
                        }
                    }
                }
            }
        }


    }
}
