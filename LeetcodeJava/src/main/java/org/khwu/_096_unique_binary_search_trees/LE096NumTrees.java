package org.khwu._096_unique_binary_search_trees;

public class LE096NumTrees {

    // MY
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0, k = i - j - 1; j >= 0 && k >= 0; j++, k--) {
                dp[i] += dp[j] * dp[k];
            }
        }
        return dp[n];
    }
}
