package leetcode;

import java.util.ArrayList;
import java.util.List;

/*����һ���ַ����������ҳ����в������ظ��ַ���?��Ӵ�?�ĳ��ȡ�

ʾ��?1:

����: "abcabcbb"
���: 3
����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
ʾ�� 2:

����: "bbbbb"
���: 1
����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
ʾ�� 3:

����: "pwwkew"
���: 3
����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
?    ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"?��һ�������У������Ӵ���

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������*/
public class Topic3 {
    public static void main(String[] args) {
        Topic3 topic3 = new Topic3();
        System.out.println(topic3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(topic3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(topic3.lengthOfLongestSubstring("pwwkew"));

        System.out.println(topic3.lengthOfLongestSubstring("dvdf"));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int result = 0;
        String sResult = null;
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndexOf = characters.lastIndexOf(c);
            if (lastIndexOf > -1) {
                if (result < characters.size()) {
                    result = characters.size();
                    sResult = characters.toString();
                }
                characters = characters.subList(lastIndexOf + 1, characters.size());
                characters.add(c);
            } else {
                characters.add(c);
            }
        }
        if (result < characters.size()) {
            result = characters.size();
            sResult = characters.toString();
        }
        System.out.println(sResult);
        return result;

    }

//    public int lengthOfLongestSubstring2(String s) {
//
//
//    }
//
//    public int lengthOfLongestSubstringChild(String s1, String s2) {
//
//        return Math.max(lengthOfLongestSubstring2(s1), lengthOfLongestSubstring2(s2));
//
//    }
}
