package art.recommend;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;

/**
 * ������Ƽ�ʵ��
 */
public abstract class BaseRecommend {
    private static final int PREFERENCE_LENGTH = 100;
    private static final int INDEX_LENGTH = 3;
    //��������Ƽ�ʵ�����Ȥƫ��,��Ȥ��-100~100
    protected double[] preferenceDisplay = new double[PREFERENCE_LENGTH];

    /**
     * ����Ƽ�ʵ���ѵ������̶� 0-1
     */
    protected float maturityGrade;

    /**
     * ƥ������������������һ���̶��Ϸ�ӳmaturityGrade
     */
    protected int matchCount = 0;


    /**
     * ���������Ƽ�ʵ��֮���ƥ�����������Ȥƫ��
     * ֻ��ѡ������������������Ϊϲ��һ��������Ƽ�ʵ���������������
     *
     * @param other ��һ���Ƽ�ʵ��
     * @param match ����֮���ƥ��� ��Χ-1~1
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
     * �ӷ��������ή��ѵ������ȣ���ֹ�Ƽ�ʵ��ѵ������֮����Ȥƫ��㶨
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
     * ��ȡ��Ȥƫ��Ĵ���
     *
     * @return ������Ȥƫ������ {@link #INDEX_LENGTH} ��ƫ�� ����С�� {@link #INDEX_LENGTH} ��ƫ����±�
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
     * @param isLow      �����Ǵӵ͵���
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
