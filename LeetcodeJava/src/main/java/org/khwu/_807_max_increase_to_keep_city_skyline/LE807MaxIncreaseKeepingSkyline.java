package org.khwu._807_max_increase_to_keep_city_skyline;

public class LE807MaxIncreaseKeepingSkyline {
}

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] buttom = new int[n];
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buttom[j] = Math.max(buttom[j], grid[i][j]);
                left[i] = Math.max(left[i], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.max(0, Math.min(buttom[j], left[i]) - grid[i][j]);
            }
        }
        return res;
    }
}