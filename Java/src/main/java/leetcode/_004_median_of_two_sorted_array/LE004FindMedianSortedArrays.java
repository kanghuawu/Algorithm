package leetcode._004_median_of_two_sorted_array;

public class LE004FindMedianSortedArrays {
    // ref: https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481
    // ref: https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2547
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int min = 0, max = len1, halfLen = (len1 + len2 + 1)/2;
        int i = 0;
        int j = 0;
        while (min <= max) {
            i = (max + min)/2;
            j = halfLen - i;
            // System.out.println(i +" "+ j);
            // nums1[i-1] < nums2[j] && nums1[i] < nums2[j-1]
            if (i < len1 && nums1[i] < nums2[j-1]) {
                min = i + 1;
            } else if (i > 0 && nums1[i-1] > nums2[j]) {
                max = i - 1;
            } else {
                break;
            }

        }
        int left = 0;
        if (i == 0) left = nums2[j-1];
        else if (j == 0) left = nums1[i-1];
        else left = Math.max(nums1[i-1], nums2[j-1]);

        if ((len1 + len2) % 2 == 1) return left;

        int right = 0;
        if (i == len1) right = nums2[j];
        else if (j == len2) right = nums1[i];
        else right = Math.min(nums1[i], nums2[j]);
        return (double) (left + right) / 2;
    }
}
