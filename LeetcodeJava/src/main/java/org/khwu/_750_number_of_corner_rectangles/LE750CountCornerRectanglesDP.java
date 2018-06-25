package org.khwu._750_number_of_corner_rectangles;

public class LE750CountCornerRectanglesDP {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = j + 1; k < n; k++) {
                    if (grid[i][k] == 0) continue;
                    res += dp[j][k];
                    dp[j][k]++;
                }
            }
        }
        return res;
    }
}
