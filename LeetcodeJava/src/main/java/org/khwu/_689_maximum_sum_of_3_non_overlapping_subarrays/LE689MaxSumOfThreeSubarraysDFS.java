package org.khwu._689_maximum_sum_of_3_non_overlapping_subarrays;

import java.util.Arrays;

public class LE689MaxSumOfThreeSubarraysDFS {

    // [-1, 0, 1, 2, 3, 4, 5, 6, 7]
    //    [ 1, 2, 1, 2, 6, 7, 5, 1]
    // [ 0, 1, 3, 4, 6,12,19,24,25]
    //                        |
    //         |
    private int max = Integer.MIN_VALUE;
    private int[] res = null;
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int[] buffer = new int[3];
        int[] accu = new int[nums.length + 1];
        accu[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            accu[i+1] += accu[i] + nums[i];
        }
        
        dfs(accu, 0, k, 3, 0, buffer);

        return res;
    }

    private void dfs(int[] accu, int idx, int k, int remain, int sum, int[] buffer) {
        if (remain == 0) {

            if (sum > max) {
                res = Arrays.copyOf(buffer, 3);
                max = sum;
            }
            return;
        }

        int oldSum = sum;
        for (int i = idx + k; i <= accu.length - k * remain; i++) {
            sum += accu[i] - accu[i - k];
            buffer[3 - remain] = i - k;
            dfs(accu, i, k, remain - 1, sum, buffer);
            sum = oldSum;
        }
    }
}
