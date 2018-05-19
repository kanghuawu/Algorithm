package org.khwu._064_minimum_path_sum;

public class LE064MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int toAdd = Integer.MAX_VALUE;
                if (i != 0) toAdd = Math.min(toAdd, grid[i-1][j]);
                if (j != 0) toAdd = Math.min(toAdd, grid[i][j-1]);
                grid[i][j] += toAdd;
            }
        }
        return grid[m-1][n-1];
    }
}
