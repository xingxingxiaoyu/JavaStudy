package leetcode.Topic1210_�����Թ��������ƶ�����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/*�㻹�ǵ���������ȫ���̰������

        ������һ��?n*n?�������Ϲ������µ��Թ���ͼ���ߵĳ���Ϊ 2��Ҳ����˵����ռȥ������Ԫ���߻�����Ͻǣ�(0, 0)?��?(0, 1)����ʼ�ƶ��������� 0 ��ʾ�յ�Ԫ���� 1 ��ʾ�ϰ������Ҫ�ƶ����Թ������½ǣ�(n-1, n-2)?��?(n-1, n-1)����

        ÿ���ƶ����߿��������ߣ�

        ���û���ϰ����������ƶ�һ����Ԫ�񡣲���Ȼ���������ˮƽ����ֱ״̬��
        ���û���ϰ����������ƶ�һ����Ԫ�񡣲���Ȼ���������ˮƽ����ֱ״̬��
        ���������ˮƽ״̬�����������������Ԫ���ǿյģ���˳ʱ����ת 90 �ȡ��ߴӣ�(r, c)��(r, c+1)���ƶ��� ��(r, c)��(r+1, c)����

        �����������ֱ״̬�����������������Ԫ���ǿյģ�����ʱ����ת 90 �ȡ��ߴӣ�(r, c)��(r+1, c)���ƶ�����(r, c)��(r, c+1)����

        �����ߵִ�Ŀ�ĵ�����������ƶ�������

        ����޷�����Ŀ�ĵأ��뷵��?-1��

        ��Դ�����ۣ�LeetCode��
        ���ӣ�https://leetcode-cn.com/problems/minimum-moves-to-reach-target-with-rotations
        ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������*/
public class Topic1210_�����Թ��������ƶ����� {
    public static void main(String[] args) {


        System.out.println("main: " + new Solution().minimumMoves(new int[][]{new int[]{0, 0, 0, 0, 0, 1},
                new int[]{1, 1, 0, 0, 1, 0},
                new int[]{0, 0, 0, 0, 1, 1},
                new int[]{0, 0, 1, 0, 1, 0},
                new int[]{0, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 0, 0}}));
    }
}

class Solution {

    //grid.lengthΪ�ߣ�grid[0].lengthΪ��
    public int minimumMoves(int[][] grid) {
        //�Ѿ��߹��˵ĵ�
        ArrayList<SnakeState> oldSnakeStates = new ArrayList<>();
        //��ǰ�����ߵĵ�
        ArrayList<SnakeState> currentSnakeStates = new ArrayList<>();
        currentSnakeStates.add(new SnakeState(0, 0, false));
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < grid.length * grid[0].length; i++) {
            int size = currentSnakeStates.size();
            for (int j = 0; j < size; j++) {
                SnakeState snakeState = currentSnakeStates.get(0);
                ArrayList<SnakeState> list = step(snakeState, grid);
                currentSnakeStates.addAll(list);
                currentSnakeStates.remove(snakeState);
                oldSnakeStates.add(snakeState);
            }
            if (currentSnakeStates.contains(new SnakeState(m - 1, n - 2, false))) {
                int index = currentSnakeStates.indexOf(new SnakeState(m - 1, n - 2, false));
                System.out.println("minimumMoves: " + currentSnakeStates.get(index).road);
                return i;
            }
            if (currentSnakeStates.size() == 0) {
                return -1;
            }
        }
        return 0;
    }

    private ArrayList<SnakeState> step(SnakeState snakeState, int[][] grid) {
        ArrayList<SnakeState> snakeStateArrayList = new ArrayList<>();
        getTranslationPoint(snakeState, grid, snakeStateArrayList);
        getRotatePoint(snakeState, grid, snakeStateArrayList);
        return snakeStateArrayList;

    }

    private void getRotatePoint(SnakeState snakeState, int[][] grid, ArrayList<SnakeState> snakeStateArrayList) {
        if (snakeState.isVertical) {
            checkRight(snakeState, grid, snakeStateArrayList);
            checkLeft(snakeState, grid, snakeStateArrayList);
        } else {
            checkTop(snakeState, grid, snakeStateArrayList);
            checkBottom(snakeState, grid, snakeStateArrayList);
        }

    }

    private void checkRight(SnakeState snakeState, int[][] grid, ArrayList<SnakeState> snakeStateArrayList) {
        try {
            if (checkSnake(snakeState, grid) && checkSnake(new SnakeState(snakeState.x, snakeState.y + 1, snakeState.isVertical), grid)) {
                realAddNext(snakeStateArrayList, snakeState, Step.vertical_top_right, new SnakeState(snakeState.x, snakeState.y, !snakeState.isVertical));
                realAddNext(snakeStateArrayList, snakeState, Step.vertical_bottom_right, new SnakeState(snakeState.x + 1, snakeState.y, !snakeState.isVertical));
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }


    private void checkLeft(SnakeState snakeState, int[][] grid, ArrayList<SnakeState> snakeStateArrayList) {
        try {
            if (checkSnake(snakeState, grid) && checkSnake(new SnakeState(snakeState.x, snakeState.y - 1, snakeState.isVertical), grid)) {
                realAddNext(snakeStateArrayList, snakeState, Step.vertical_top_left, new SnakeState(snakeState.x, snakeState.y - 1, !snakeState.isVertical));
                realAddNext(snakeStateArrayList, snakeState, Step.vertical_bottom_left, new SnakeState(snakeState.x + 1, snakeState.y - 1, !snakeState.isVertical));
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }

    private void checkTop(SnakeState snakeState, int[][] grid, ArrayList<SnakeState> snakeStateArrayList) {
        try {
            if (checkSnake(snakeState, grid) && checkSnake(new SnakeState(snakeState.x - 1, snakeState.y, snakeState.isVertical), grid)) {
                realAddNext(snakeStateArrayList, snakeState, Step.horizontal_left_top, new SnakeState(snakeState.x - 1, snakeState.y, !snakeState.isVertical));
                realAddNext(snakeStateArrayList, snakeState, Step.horizontal_right_top, new SnakeState(snakeState.x - 1, snakeState.y + 1, !snakeState.isVertical));
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }

    private void checkBottom(SnakeState snakeState, int[][] grid, ArrayList<SnakeState> snakeStateArrayList) {
        try {
            if (checkSnake(snakeState, grid) && checkSnake(new SnakeState(snakeState.x + 1, snakeState.y, snakeState.isVertical), grid)) {
                realAddNext(snakeStateArrayList, snakeState, Step.horizontal_left_bottom, new SnakeState(snakeState.x, snakeState.y, !snakeState.isVertical));
                realAddNext(snakeStateArrayList, snakeState, Step.horizontal_right_bottom, new SnakeState(snakeState.x, snakeState.y + 1, !snakeState.isVertical));
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }

    private void realAddNext(ArrayList<SnakeState> snakeStateArrayList, SnakeState snakeState, Step step, SnakeState nextSnake) {
        LinkedList<Step> road = new LinkedList<>(snakeState.road);
        road.add(step);
        snakeStateArrayList.add(nextSnake.setRoad(road));
    }

    private void getTranslationPoint(SnakeState snakeState, int[][] grid, ArrayList<SnakeState> snakeStateArrayList) {
        SnakeState snakeState1 = new SnakeState(snakeState.x - 1, snakeState.y, snakeState.isVertical);
        SnakeState snakeState2 = new SnakeState(snakeState.x + 1, snakeState.y, snakeState.isVertical);
        SnakeState snakeState3 = new SnakeState(snakeState.x, snakeState.y - 1, snakeState.isVertical);
        SnakeState snakeState4 = new SnakeState(snakeState.x, snakeState.y + 1, snakeState.isVertical);
        if (checkSnake(snakeState1, grid)) {
            realAddNext(snakeStateArrayList, snakeState, Step.top, snakeState1);
        }
        if (checkSnake(snakeState2, grid)) {
            realAddNext(snakeStateArrayList, snakeState, Step.bottom, snakeState2);
        }
        if (checkSnake(snakeState3, grid)) {
            realAddNext(snakeStateArrayList, snakeState, Step.left, snakeState3);
        }
        if (checkSnake(snakeState4, grid)) {
            realAddNext(snakeStateArrayList, snakeState, Step.right, snakeState4);
        }
    }

    private boolean checkSnake(SnakeState snakeState, int[][] grid) {
        try {
            if (snakeState.isVertical) {
                return checkPoint(snakeState.x, snakeState.y, grid) & checkPoint(snakeState.x + 1, snakeState.y, grid);
            } else {
                return checkPoint(snakeState.x, snakeState.y, grid) & checkPoint(snakeState.x, snakeState.y + 1, grid);
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean checkPoint(int x, int y, int[][] grid) {
        return grid[x][y] == 0;
    }

    enum Step {
        right,
        left,
        top,
        bottom,
        //�ߺ��ţ���ߵ�����̶���������ת
        horizontal_left_top,
        horizontal_left_bottom,
        horizontal_right_top,
        horizontal_right_bottom,
        vertical_top_left,
        vertical_bottom_left,
        vertical_top_right,
        vertical_bottom_right,
    }

    //�����Ϸ��ĵ���x��y
    static class SnakeState implements Cloneable {
        int x;
        int y;
        boolean isVertical;
        LinkedList<Step> road = new LinkedList<>();

        public SnakeState(int x, int y, boolean isVertical) {
            this.x = x;
            this.y = y;
            this.isVertical = isVertical;
        }

        public SnakeState setRoad(LinkedList<Step> road) {
            this.road = road;
            return this;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", isVertical=" + isVertical +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SnakeState snakeState = (SnakeState) o;
            return x == snakeState.x &&
                    y == snakeState.y &&
                    isVertical == snakeState.isVertical;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, isVertical);
        }
    }
}


