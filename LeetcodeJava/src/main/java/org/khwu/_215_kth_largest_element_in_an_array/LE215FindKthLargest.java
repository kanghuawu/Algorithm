package org.khwu._215_kth_largest_element_in_an_array;

import java.util.Random;

public class LE215FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return -1;
        shuffle(nums);
        int n = nums.length;
        int p;
        int i = 0;
        int j = n-1;
        while (true) {
            p = partition(nums, i, j);
            if (n - p > k) {
                i = p + 1;
            } else if (n - p < k) {
                j = p - 1;
            } else {
                return nums[p];
            }
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo;
        int j = hi+1;
        while (i < j) {
            for (i++; i < hi && nums[i] < pivot; i++);
            for (j--; j > lo && nums[j] > pivot; j--);
            if (i < j) swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            swap(nums, i, rand.nextInt(n));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
