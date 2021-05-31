package leetcode; 
 
//翻转int 
public class Topic190 { 
    public static void main(String[] args) { 
 
        System.out.println("main: " + turnInt(1)); 
        System.out.println("main: " + turnInt(0xffffffff)); 
        System.out.println("main: " + turnInt(2)); 
        System.out.println("main: " + turnInt(43261596)); 
        System.out.println("main: " + turnInt(1)); 
    } 
 
    private static int turnInt(int number) { 
        System.out.println("turnInt: " + Integer.toHexString(number)); 
        int result = 0; 
        int flag = 1; 
        for (int i = 0; i < 32; i++) { 
            //获取当前位的数字i=0的时候或取得是最低位的 
            int currentPos = flag & number; 
            //移到目标数字的位置 
            if (31 - i * 2 > 0) { 
                currentPos = currentPos << (31 - i * 2); 
            } else { 
                currentPos = currentPos >>> -(31 - i * 2); 
            } 
            //放到结果数字 
            result = result | currentPos; 
//            System.out.println("turnInt: i " + i + " result " + Integer.toHexString(result)); 
//            System.out.println("turnInt: i " + i + " currentPos " + Integer.toHexString(currentPos)); 
//            System.out.println("turnInt: i " + i + " flag " + Integer.toHexString(flag)); 
 
            flag <<= 1; 
        } 
        System.out.println("main: " + Integer.toBinaryString(number)); 
        System.out.println("main: " + Integer.toBinaryString(result)); 
 
        return result; 
    } 
} 
