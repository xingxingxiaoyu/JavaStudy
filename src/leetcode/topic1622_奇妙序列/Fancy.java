package leetcode.topic1622_奇妙序列; 
 
import java.util.ArrayList; 
/* 
请你实现三个 API append，addAll?和?multAll?来实现奇妙序列。 
 
        请实现?Fancy?类 ： 
 
        Fancy()?初始化一个空序列对象。 
        void append(val) 将整数?val?添加在序列末尾。 
        void addAll(inc)?将所有序列中的现有数值都增加?inc?。 
        void multAll(m)?将序列中的所有现有数值都乘以整数?m?。 
        int getIndex(idx) 得到下标为?idx?处的数值（下标从 0 开始），并将结果对?109 + 7?取余。如果下标大于等于序列的长度，请返回?-1?。 
 
        来源：力扣（LeetCode） 
        链接：https://leetcode-cn.com/problems/fancy-sequence 
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/ 
public class Fancy { 
 
    private ArrayList<Integer> list = new ArrayList<>(); 
 
    public Fancy() { 
 
    } 
 
    public void append(int val) { 
        list.add(val); 
    } 
 
    public void addAll(int inc) { 
        for (int i = 0; i < list.size(); i++) { 
            list.set(i, list.get(i) + inc); 
        } 
    } 
 
    public void multAll(int m) { 
        for (int i = 0; i < list.size(); i++) { 
            list.set(i, list.get(i) * m); 
        } 
    } 
 
    public int getIndex(int idx) { 
        if (idx >= list.size()) { 
            return -1; 
        } 
        int value = list.get(idx); 
        value = value % (10_0000_0000 + 7); 
        return value; 
    } 
 
    public static void main(String[] args) { 
        System.out.println("main: "+(10_0000_0000 + 7)); 
    } 
} 
