package other;

public class ColorUtil {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            double alpha = i / 10.0;
            System.out.println(alpha + " " + Integer.toHexString((int) (alpha * 255 + 0.5)));

        }
    }
}
