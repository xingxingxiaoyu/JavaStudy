package art.class34;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Class3 implements Serializable, Cloneable {
    private int num = 1;

    public int add(int i) {
        int j = 10;
        num = num + i;
        return num;
    }


    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(null);
        integers.add(null);

        randomDelete(integers);
    }

    private static void randomDelete(ArrayList<Integer> integers) {
        Random random = new Random();
        int sum = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) != null) sum++;
        }
        int nextInt = random.nextInt(sum);
        int index = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) == null) continue;
            if (nextInt == index) {
                integers.remove(i);
                break;
            }
            index++;
        }
    }
}