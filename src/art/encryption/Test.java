package art.encryption;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        System.out.println(MD5Util.getMD5String("123"));
        System.out.println(MD5.getInstance().getMD5("123"));
    }
}
