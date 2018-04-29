package org.khwu._209_minimum_size_subarray_sum;

public class LE209MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int acc = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < n; i++) {
            acc += nums[i];
            while (acc >= s && i >= j) {
                res = Math.min(i - j, res);
                acc -= nums[j];
                j++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res + 1;
    }
}
