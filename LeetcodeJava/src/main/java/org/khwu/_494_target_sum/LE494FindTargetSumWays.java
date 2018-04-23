package org.khwu._494_target_sum;

public class LE494FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null) return 0;

        int sum = 0;
        for (int n : nums) sum += n;

        if (S > sum || (sum + S) % 2 == 1) return 0;

        return subsetSum(nums, (sum + S) >> 1);
    }

    private int subsetSum(int[] nums, int sum) {
        int[] dp = new int[sum + 1];

        dp[0] = 1;
        for (int n : nums) {
            for (int j = sum; j >= n; j--) {
                dp[j] += dp[j - n];
            }
        }
        return dp[sum];
    }
}
