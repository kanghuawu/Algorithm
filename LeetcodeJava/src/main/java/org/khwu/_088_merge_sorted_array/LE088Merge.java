package org.khwu._088_merge_sorted_array;

public class LE088Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[t--] = nums1[m--];
            } else {
                nums1[t--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[t--] = nums2[n--];
        }
    }
}
