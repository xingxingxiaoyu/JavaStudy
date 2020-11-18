package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Match {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> permissions = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (random.nextBoolean()) {
                permissions.add("abcd" + i);
            }
        }
        ArrayList<ArrayList<String>> itemList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 30; j++) {
                if (random.nextInt(100) < 10) {
                    list.add("abcd" + j);
                }
            }
            itemList.add(list);
        }

        long currentTimeMillis = System.currentTimeMillis();
        itemList.forEach(new Consumer<ArrayList<String>>() {
            @Override
            public void accept(ArrayList<String> strings) {
                strings.forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        permissions.forEach(new Consumer<String>() {
                            @Override
                            public void accept(String permission) {
                                if (permission.equals(s)) {

                                }
                            }
                        });
                    }
                });
            }
        });
        System.out.println(System.currentTimeMillis() - currentTimeMillis);


    }
}

