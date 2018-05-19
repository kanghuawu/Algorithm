package org.khwu._063_unique_paths_ii;

public class LE063UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] ob) {
        if (ob == null || ob.length == 0) return 0;
        if (ob[0].length == 0) return 1;
        if (ob[0][0] == 1) return 0;
        int m = ob.length;
        int n = ob[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (ob[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i-1 >= 0 && ob[i-1][j] == 0) dp[i][j] += dp[i-1][j];
                if (j-1 >= 0 && ob[i][j-1] == 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
