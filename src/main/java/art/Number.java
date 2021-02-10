package art;

import java.awt.*;

//数值与位运算符
public class Number {
    public static void main(String[] args) {
//        System.out.println(Integer.class.getName());
//        System.out.println(int.class.getName());
//        System.out.println(Integer.TYPE.getName());
//
//        System.out.println(Integer.TYPE == int.class);
//        System.out.println(Integer.class == int.class);

        System.out.println(Integer.toHexString(0x7fffffff >> 4));
        System.out.println(Integer.toHexString(0x8fffffff >> 4));
        System.out.println(Integer.toHexString(0xffffffff >> 4));
        System.out.println(Integer.toHexString(0x0fffffff >> 4));
        System.out.println();
        System.out.println(Integer.toHexString(0x7fffffff << 4));
        System.out.println(Integer.toHexString(0x8fffffff << 4));
        System.out.println(Integer.toHexString(0xffffffff << 4));
        System.out.println(Integer.toHexString(0x0fffffff << 4));
        System.out.println();
        System.out.println(Integer.toHexString(0x7fffffff >>> 4));
        System.out.println(Integer.toHexString(0x8fffffff >>> 4));
        System.out.println(Integer.toHexString(0xffffffff >>> 4));
        System.out.println(Integer.toHexString(0x0fffffff >>> 4));

        System.out.println(0x8fffffff << 4);
        System.out.println(0x8fffffff);
        System.out.println(0x8fffffff);


        System.out.println(Integer.toHexString((byte) -10));
        System.out.println(Integer.toHexString((byte) -30));


        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);


        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.toHexString(-10));
        System.out.println(Integer.toHexString(Integer.MAX_VALUE));
        System.out.println(Integer.toHexString(Integer.MAX_VALUE));

        System.out.println(Long.toHexString(-1));
        System.out.println(Long.toHexString(Long.MAX_VALUE));

        print(10);
        print(-10);
        print(0.1f);
        print(-12.75f);
        print(3.14f);

        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(100));


        print(10);
        print(-0.125f);

        System.out.println(Long.toBinaryString(Double.doubleToLongBits(10)));

        System.out.println(Float.intBitsToFloat(0b1_0000_0000_10000000000000000000000));
        System.out.println(0.5 * Math.pow(2, -126));

        System.out.println(5.88 / 3 * 4);


        System.out.println(1.0 - 0.42);
        System.out.println(0.05 + 0.01 == 0.06);
        System.out.println((int) (4.015 * 100 + 0.5));

        System.out.println(Math.abs(0.05 + 0.01 - 0.06) < 1e-5);
        System.out.println(Math.round(4.015 * 100 + 0.5));

        System.out.println(~1);

        System.out.println(1 << 1);
        System.out.println(4 >> 1);
        System.out.println(4 >>> 1);

        System.out.println(-1 >> 1);

        System.out.println();
        System.out.println(Integer.MAX_VALUE << 1);
        System.out.println(0xBFFFFFFF);
        System.out.println(0xBFFFFFFF << 1);

        System.out.println(-1 >>> 1);
//        Color.RED

    }


    private static void print(float a) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(Float.floatToIntBits(a)));
        for (int i = 0; i < 32 - s.length(); i++) {
            s.insert(0, "0");
        }
        System.out.println("sign" + s.substring(0, 1));
        System.out.println("Exponent" + s.substring(1, 9));
        System.out.println("Significand" + s.substring(9));

    }


}
