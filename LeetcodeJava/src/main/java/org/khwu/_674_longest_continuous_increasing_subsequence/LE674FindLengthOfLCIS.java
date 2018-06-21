package org.khwu._674_longest_continuous_increasing_subsequence;

public class LE674FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        int n = nums.length;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] < nums[i]) count++;
            else count = 1;
            res = Math.max(res, count);
        }
        return res;
    }
}
