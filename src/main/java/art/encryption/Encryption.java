package art.encryption;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
���������޵���ǿ�޽���ܴ�
 */
public class Encryption {
    public static String KEY;

    public static void main(String[] args) {
        getKey();
        System.out.println("������Կ");
        System.out.println(KEY);
        System.out.println("ԭʼ�ַ���");
        System.out.println("123hwkejf235sfd2435sfhkj");
        System.out.println("���ܺ���ַ���");
        System.out.println(encode("123hwkejf235sfd2435sfhkj"));
        System.out.println("���ܺ���ܵ��ַ���");
        System.out.println(decode(encode("123hwkejf235sfd2435sfhkj")));

    }

    private static void getKey() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            list.add(i + 97);
        }
        Random random = new Random();
        StringBuilder key = new StringBuilder();
        while (list.size() > 0) {
            key.append((char) (int) list.remove(random.nextInt(list.size())));
        }
        KEY = key.toString();
    }

    /*
        ����
     */
    private static String encode(String str) {
        char[] keyChars = KEY.toCharArray();
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 97 && aChar < 97 + 26) {
                result.append(keyChars[(int) aChar - 97]);
            } else {
                result.append(aChar);
            }
        }
        return result.toString();
    }

    /*
      ����
      */
    private static String decode(String str) {
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 97 && aChar < 97 + 26) {
                int index = KEY.indexOf(String.valueOf(aChar));
                result.append((char) (index + 97));
            } else {
                result.append(aChar);
            }
        }
        return result.toString();
    }
}
