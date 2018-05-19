package org.khwu._062_unique_paths;

public class LE062UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i-1 >= 0) dp[i][j] += dp[i-1][j];
                if (j-1 >= 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
