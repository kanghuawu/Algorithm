package org.khwu._377_combination_sum_iv;

import java.util.Arrays;

public class LE377CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1); // don't use 0 -> get TLE if use 0
        dp[0] = 1;
        return dfs(nums, dp ,target);
    }

    private int dfs(int[] nums, int[] dp, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target)
                res += dfs(nums, dp, target - nums[i]);
        }
        dp[target] = res;
        return res;
    }
}
