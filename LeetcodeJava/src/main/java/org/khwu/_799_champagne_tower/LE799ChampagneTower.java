package org.khwu._799_champagne_tower;

public class LE799ChampagneTower {

    public double champagneTowerV2(int poured, int query_row, int query_glass) {
        int n = query_row + 1;
        double[] dp = new double[n+1];
        dp[0] = poured;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j] = Math.max((dp[j] - 1) / 2, 0);
                dp[j+1] += dp[j];
            }
        }
        return Math.min(dp[query_glass], 1);
    }

    public double champagneTowerV1(int poured, int query_row, int query_glass) {
        int n = query_row;
        double[][] dp = new double[n+1][n+1];
        dp[0][0] = poured;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    dp[i+1][j] += (dp[i][j] - 1) / 2;
                    dp[i+1][j+1] += (dp[i][j] - 1) / 2;
                    dp[i][j] = 1;
                }

            }
        }

        return Math.min(dp[query_row][query_glass], 1);
    }
}
