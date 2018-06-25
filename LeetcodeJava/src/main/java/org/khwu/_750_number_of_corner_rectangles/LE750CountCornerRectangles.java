package org.khwu._750_number_of_corner_rectangles;

public class LE750CountCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int c = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) c++;
                }
                if (c > 1) res += c * (c - 1) / 2;
            }
        }
        return res;
    }
}
