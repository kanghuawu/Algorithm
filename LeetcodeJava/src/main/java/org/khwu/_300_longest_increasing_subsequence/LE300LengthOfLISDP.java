package org.khwu._300_longest_increasing_subsequence;

public class LE300LengthOfLISDP {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res + 1;
    }
}
