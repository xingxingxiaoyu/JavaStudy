package other;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
    public static void main(String[] args) {
//        testA();
//        testB();
        try {
            String aa_aa = URLEncoder.encode("aa aa", "utf-8");
            String decode = URLDecoder.decode(aa_aa, "utf-8");
            System.out.println(aa_aa);
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void testA() {
        int i = 100;
        int j = 200;
        boolean b;
        long l = System.currentTimeMillis();
        for (long k = 0; k < 1000_000_000; k++) {
            i++;
            b = i > j;
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    private static void testB() {
        int i = 100;
        int j = 0;
        boolean b;
        long l = System.currentTimeMillis();
        for (long k = 0; k < 1000_000_000; k++) {
            i++;
            b = false;
            j = i;
        }
        System.out.println(System.currentTimeMillis() - l);
    }
}
