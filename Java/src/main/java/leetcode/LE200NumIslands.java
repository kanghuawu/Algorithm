package leetcode;

public class LE200NumIslands {
    // MY
    private int count;
    private int xLen;
    private int yLen;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        xLen = grid.length;
        yLen = grid[0].length;
        for (int i = 0; i < xLen; i++ ) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j< 0 || i >= xLen || j >= yLen || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
    }
}
