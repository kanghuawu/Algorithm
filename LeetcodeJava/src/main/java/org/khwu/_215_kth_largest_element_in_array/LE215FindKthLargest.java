package org.khwu._215_kth_largest_element_in_array;

import java.util.Random;

public class LE215FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // System.out.println(Arrays.toString(nums));
        // shuffle(nums);
        int tar = nums.length-k;
        // System.out.println(Arrays.toString(nums));
        return select(nums, tar, 0, nums.length-1);
    }

    private int select(int[] nums, int tar, int le, int ri) {
        if (le == ri) return nums[le];
        int par = partition(nums, le, ri);
        System.out.println(le + " " + par + " " + ri);
        if (par > tar) return select(nums, tar, le, par-1);
        else if (par < tar) return select(nums, tar, par+1, ri);
        else return nums[tar];
    }

    private int partition(int[] nums, int le, int ri) {
        int piv = nums[le];
        int i = le;
        int j = ri+1;
        while (i < j) {
            for (i++; i < ri && nums[i] < piv; i++) {}
            for (j--; j > le && nums[j] >= piv; j--) {}
            if (i < j) swap(nums, i , j);
        }
        swap(nums, le, j);
        return j;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(n);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
