package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 *��һ�������ַ������ݸ������������Դ������¡������ҽ���?Z �������С�

���������ַ���Ϊ "LEETCODEISHIRING"?����Ϊ 3 ʱ���������£�

L   C   I   R
E T O E S I I G
E   D   H   N
֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��

����ʵ��������ַ�������ָ�������任�ĺ�����

string convert(string s, int numRows);
ʾ��?1:

����: s = "LEETCODEISHIRING", numRows = 3
���: "LCIRETOESIIGEDHN"
ʾ��?2:

����: s = "LEETCODEISHIRING", numRows =?4
���:?"LDREOEIIECIHNTSG"
����:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/zigzag-conversion
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
