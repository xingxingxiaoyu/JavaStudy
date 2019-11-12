package leetcode;

import java.util.ArrayList;
import java.util.List;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
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
