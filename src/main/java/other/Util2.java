package other;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util2 {
    public static void main(String[] args) {

        int x = 'a' - 'A';
        System.out.println(x);
        File file = new File("D:\\develop\\code\\android\\work\\A_SystemUpgradeCommon\\app\\src\\main\\java\\com\\konka\\systemupgrade\\ui\\fragment");
        File[] files = file.listFiles();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            String fragmentName = name.substring(0, name.length() - 3);
            String varName = (char)(fragmentName.charAt(0) + x) + fragmentName.substring(1);
            String s = "private var " + varName + ": " + fragmentName + " = " + fragmentName + "()";
            System.out.println(s);
        }
    }
}
