package org.khwu._673_number_of_longest_increasing_subsequence;

public class LE673FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLen = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {

                if (nums[j] >= nums[i]) continue;

                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (dp[i] == dp[j] + 1) {
                    count[i] += count[j];
                }
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                res = count[i];
            } else if (maxLen == dp[i]) {
                res += count[i];
            }
        }
        return res;
    }
}
