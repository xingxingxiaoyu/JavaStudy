package art.recommend;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;

/**
 * 抽象的推荐实体
 */
public abstract class BaseRecommend {
    private static final int PREFERENCE_LENGTH = 100;
    private static final int INDEX_LENGTH = 3;
    //描述这个推荐实体的兴趣偏向,兴趣从-100~100
    protected double[] preferenceDisplay = new double[PREFERENCE_LENGTH];

    /**
     * 这个推荐实体的训练成熟程度 0-1
     */
    protected float maturityGrade;

    /**
     * 匹配次数，这个参数能在一定程度上反映maturityGrade
     */
    protected int matchCount = 0;


    /**
     * 根据两个推荐实体之间的匹配度来修正兴趣偏向
     * 只挑选几个代表来修正，因为喜好一般是针对推荐实体的显著特征来的
     *
     * @param other 另一个推荐实体
     * @param match 两者之间的匹配度 范围-1~1
     */
    public void preferenceMatch(BaseRecommend other, float match) {
        int[] index = getPreferenceDisplayHighIndex();
        int[] otherIndex = other.getPreferenceDisplayHighIndex();
        int[] mixIndex = mixIndex(index, otherIndex);
        for (int i = 0; i < mixIndex.length; i++) {
            maturityChange(preferenceMatchIndex(mixIndex[i], other, match));
            other.maturityChange(other.preferenceMatchIndex(mixIndex[i], this, match));
        }
        matchCount++;
        other.matchCount++;
    }

    /**
     * 挥发函数，会降低训练成熟度，防止推荐实体训练成熟之后兴趣偏向恒定
     */
    protected abstract void maturityChange(int grade);

    private int preferenceMatchIndex(int index, BaseRecommend other, float match) {
        return preferenceMatchIndex(index, other.preferenceDisplay[index], match);
    }

    protected abstract int preferenceMatchIndex(int index, double otherDisplay, float match);

    private int[] mixIndex(int[] index, int[] otherIndex) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < index.length; i++) {
            integers.add(index[i]);
        }
        for (int i = 0; i < otherIndex.length; i++) {
            integers.add(otherIndex[i]);
        }
        Integer[] objects = (Integer[]) integers.toArray();
        return Arrays.stream(objects).mapToInt(Integer::intValue).toArray();
    }

    /**
     * 获取兴趣偏向的代表
     *
     * @return 返回兴趣偏向最大的 {@link #INDEX_LENGTH} 个偏向 和最小的 {@link #INDEX_LENGTH} 个偏向的下标
     */
    private int[] getPreferenceDisplayHighIndex() {
        int[] indexArray = new int[INDEX_LENGTH * 2];
        for (int i = 1; i < PREFERENCE_LENGTH; i++) {
            if (preferenceDisplay[i] > preferenceDisplay[indexArray[0]]) {
                indexArray[0] = i;
                sortHigh(indexArray);
            } else if (preferenceDisplay[i] < preferenceDisplay[indexArray[INDEX_LENGTH]]) {
                indexArray[INDEX_LENGTH] = i;
                sortLow(indexArray);
            }
        }
        return indexArray;
    }

    private void sortLow(int[] indexArray) {
        sortByOffset(indexArray, INDEX_LENGTH, true);
    }

    private void sortHigh(int[] indexArray) {
        sortByOffset(indexArray, 0, false);
    }

    /**
     * @param indexArray
     * @param offset
     * @param isLow      排序是从低到高
     */
    private void sortByOffset(int[] indexArray, int offset, boolean isLow) {
        for (int i = offset + 1; i < INDEX_LENGTH; i++) {
            if (preferenceDisplay[indexArray[i - 1]] > preferenceDisplay[indexArray[i]] ^ isLow) {
                int index = indexArray[i];
                indexArray[i] = indexArray[i - 1];
                indexArray[i - 1] = index;
            }
        }
    }


}
