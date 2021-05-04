package other;

import java.util.ArrayList;
import java.util.List;

public class TestString {
    public static void main(String[] args) {

    }

    private static List<Integer> seach(String keyString, String targetString) {
        ArrayList<Integer> integers = new ArrayList<>();
        char[] keyChars = keyString.toCharArray();
        char[] targetChars = targetString.toCharArray();
        for (int i = 0; i < targetChars.length; i++) {
            for (int j = 0; j < keyChars.length; j++) {
                if (i + j >= targetChars.length || targetChars[i + j] != keyChars[j]) {
                    break;
                }
                if (j == keyChars.length - 1) {
                    integers.add(i);

                }
            }
        }
        return integers;
    }
}
