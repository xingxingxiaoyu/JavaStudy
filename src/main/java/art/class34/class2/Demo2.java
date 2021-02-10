package art.class34.class2;

import java.lang.ref.SoftReference;

public class Demo2 {
    static class Soft {
        private byte[] bytes = new byte[1024 * 1024 * 120];
    }

    public static void main(String[] args) {
        SoftReference<Soft> softSoftReference = new SoftReference<>(new Soft());
        System.out.println(softSoftReference.get());
        Soft soft = new Soft();
        System.out.println(softSoftReference.get());

    }
}
