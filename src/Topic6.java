import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Topic6 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println((7 & i) + " " + (8 & i) + " " + (15 & i));
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("","");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());

        }

        System.out.println(10 << 1);
        System.out.println(new Topic6().convert("LEETCODEISHIRING", 3));
        System.out.println(new Topic6().convert("LEETCODEISHIRING", 4));

    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        char[][] chars = new char[s.length()][numRows];
        int x = 0, y = 0;
        boolean isDown = true;
        for (int i = 0; i < s.length(); i++) {
            chars[x][y] = s.charAt(i);
            if (isDown) {
                y++;
                if (y == numRows - 1) {
                    isDown = false;
                }
            } else {
                x++;
                y--;
                if (y == 0) {
                    isDown = true;
                }
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (chars[j][i] != 0) {
                    stringBuilder.append(chars[j][i]);
                }

            }

        }

        return stringBuilder.toString();

    }


}
