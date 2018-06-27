package org.khwu._764_largest_plus_sign;

public class LE764OrderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0 || i == N - 1 || j == N - 1) dp[i][j] = 1;
                else dp[i][j] = N;
            }
        }

        for (int[] mine : mines) {
            int x = mine[0];
            int y = mine[1];
            dp[x][y] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, m = 0, n = 0, p = 0; j < N; j++, k--) {
                l = dp[i][j] == 0 ? 0 : l + 1;
                dp[i][j] = Math.min(dp[i][j], l);
                m = dp[i][k] == 0 ? 0 : m + 1;
                dp[i][k] = Math.min(dp[i][k], m);
                n = dp[j][i] == 0 ? 0 : n + 1;
                dp[j][i] = Math.min(dp[j][i], n);
                p = dp[k][i] == 0 ? 0 : p + 1;
                dp[k][i] = Math.min(dp[k][i], p);
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }

        // for (int i = 0; i < N; i++)
        //     System.out.println(Arrays.toString(dp[i]));

        return res;
    }
}
