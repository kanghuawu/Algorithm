package org.khwu._200_num_islands;

public class LE200NumIslandsDFS {
    // MY
//    private int count;
//    private int xLen;
//    private int yLen;
//    public int numIslands(char[][] grid) {
//        if (grid.length == 0) return 0;
//
//        xLen = grid.length;
//        yLen = grid[0].length;
//        for (int i = 0; i < xLen; i++ ) {
//            for (int j = 0; j < yLen; j++) {
//                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//    private void dfs(char[][] grid, int i, int j) {
//        if (i < 0 || j< 0 || i >= xLen || j >= yLen || grid[i][j] == '0') return;
//
//        grid[i][j] = '0';
//        dfs(grid, i + 1, j);
//        dfs(grid, i, j + 1);
//        dfs(grid, i, j - 1);
//        dfs(grid, i - 1, j);
//    }

    // MY 2017-12-27
    public int numIslands(char[][] grid) {
        int island = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    island++;
                }
            }
        }
        return island;
    }

    private void dfs(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] == '0' || grid[row][col] == '3') {
            return;
        }

        if (grid[row][col] == '1') {
            grid[row][col] = '3';
        }

        dfs(row - 1, col, grid);
        dfs(row + 1, col, grid);
        dfs(row, col - 1, grid);
        dfs(row, col + 1, grid);
    }
}
