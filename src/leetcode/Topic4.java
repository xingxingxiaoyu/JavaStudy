package leetcode;

/*给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

        请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

        你可以假设 nums1 和 nums2 不会同时为空。

        示例 1:

        nums1 = [1, 3]
        nums2 = [2]

        则中位数是 2.0
        示例 2:

        nums1 = [1, 2]
        nums2 = [3, 4]

        则中位数是 (2 + 3)/2 = 2.5*/
public class Topic4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a1 = 0;
        int a2 = 0;
        int b1 = nums1.length;
        int b2 = nums2.length;

        return 10;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2, int a1, int b1, int a2, int b2, int index) {
        if (nums1[(a1 + b1) / 2] < nums2[(a2 + b2) / 2]) {
            
        }
        return 10;
    }
}
