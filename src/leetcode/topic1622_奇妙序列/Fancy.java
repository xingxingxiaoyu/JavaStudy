package leetcode.topic1622_��������;

import java.util.ArrayList;
/*
����ʵ������ API append��addAll?��?multAll?��ʵ���������С�

        ��ʵ��?Fancy?�� ��

        Fancy()?��ʼ��һ�������ж���
        void append(val) ������?val?���������ĩβ��
        void addAll(inc)?�����������е�������ֵ������?inc?��
        void multAll(m)?�������е�����������ֵ����������?m?��
        int getIndex(idx) �õ��±�Ϊ?idx?������ֵ���±�� 0 ��ʼ�������������?109 + 7?ȡ�ࡣ����±���ڵ������еĳ��ȣ��뷵��?-1?��

        ��Դ�����ۣ�LeetCode��
        ���ӣ�https://leetcode-cn.com/problems/fancy-sequence
        ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������*/
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