package other;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String a = "sdf" + "sdfhjΩ" + "gsdjfgsdj";
        String b = "";
        for (int i = 0; i < 10; i++) {
            b += i;
        }

    }


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

//    public static void main(String[] args) {
////        System.out.println(Integer.toHexString(Float.floatToIntBits(-3.2237332f)));
//
////        HashMap<Object, Object> hashMap = new HashMap<>();
////        hashMap.put(1, 1);
////        hashMap.put(2, 5);
////        hashMap.put(8, 123);
////        hashMap.put(1, 123423);
////        Iterator<Object> iterator = hashMap.values().iterator();
////        while (iterator.hasNext()) {
////            System.out.println(iterator.next());
////        }
//
////        int n = 1000;
////        double sum = 0;
////        for (int i = 0; i < n; i++) {
////            sum += 1.0 / n * (i * 1.0 / n);
////        }
////        System.out.println(sum);
////        System.out.println(Integer.MAX_VALUE / 1000 / 3600 / 24);
////        for (int i = 0; i < 5; i++) {
////            for (int j = 0; j < 5; j++) {
////                for (int k = 0; k < 5; k++) {
////                    for (int l = 0; l < 5; l++) {
////                        for (int m = 0; m < 5; m++) {
////                            for (int n = 0; n < 5; n++) {
////                                System.out.println(String.valueOf(i + 1) +
////                                        String.valueOf(j + 1) +
////                                        String.valueOf(k + 1) +
////                                        String.valueOf(l + 1) +
////                                        String.valueOf(m + 1) +
////                                        String.valueOf(n + 1));
////
////                            }
////                        }
////                    }
////                }
////            }
////        }
//
//        System.out.println(add(127,-123));
//
//    }
//    public static int add(int a, int b) {
//        int carry = 0;            // 是否需要进位
//        while (b != 0) {
//            carry = (a & b) << 1;
//            a ^= b;
//            b = carry;
//        }
//        return a;
//    }
//
////    private static String region(int start, int end) {
////        return "(" + start + " ... " + end + ")";
////    }
////
////    private void checkRange(final String operation, int start, int end) {
////        if (end < start) {
////            throw new IndexOutOfBoundsException(operation + " " +
////                    region(start, end) + " has end before start");
////        }
////
////        int len = 0;
////
////        if (start > len || end > len) {
////            throw new IndexOutOfBoundsException(operation + " " +
////                    region(start, end) + " ends beyond length " + len);
////        }
////
////        if (start < 0 || end < 0) {
////            throw new IndexOutOfBoundsException(operation + " " +
////                    region(start, end) + " starts before 0");
////        }
////    }

//    public static void main(String[] args) {
////        System.out.println(String.format("%.2f", (2146379135.0 / 1024 / 1024)) + "M");
//
////        try {
////            InetAddress[] allByName = InetAddress.getAllByName("kkmsg.kkapp.com");
////            System.out.println(Arrays.toString(allByName));
////        } catch (UnknownHostException e) {
////            e.printStackTrace();
////        }
//
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SS");
////        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-0:00"));
////        System.out.println(simpleDateFormat.format(new Date(1000)));
//
////        String path = "D:\\develop\\code\\android\\work\\A_SystemUpgradeCommon\\app\\src\\main\\res\\";
////        File file = new File(path + "drawable");
////        File[] files = file.listFiles();
////        for (int i = 0; i < files.length; i++) {
////            File targetFile = files[i];
////            String name = targetFile.getName();
////            if (name.contains("land")) {
////                targetFile.renameTo(new File(path + "drawable-land\\" + targetFile.getName().replace("_land", "")));
////            }
////        }
//
//        System.out.println("main: " + String.format("%.2f" , 1.127214));
//    }
}
