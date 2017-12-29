package leetcode._200numislands;

import java.util.LinkedList;
import java.util.Queue;

public class LE200NumIslandsBFS {

    // MY BFS 2017-12-26
    private int rowLen;
    private int colLen;
    private char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int island = 0;
        this.rowLen = grid.length;
        if (rowLen == 0) {
            return 0;
        }
        this.colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j);
                    island++;
                }
            }
        }
        return island;
    }

    private boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen) {
            return false;
        }
        if (grid[i][j] != '1') {
            return false;
        }
        return true;
    }

    private void bfs(int i, int j) {
        grid[i][j] = '3';
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * colLen + j);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int row = pos / colLen;
            int col = pos % colLen;
            if (isValid(row + 1, col)) {
                queue.offer(pos + colLen);
                grid[row + 1][col] = '3';
            }
            if (isValid(row - 1, col)) {
                queue.offer(pos - colLen);
                grid[row - 1][col] = '3';
            }
            if (isValid(row, col + 1)) {
                queue.offer(pos + 1);
                grid[row][col + 1] = '3';
            }
            if (isValid(row, col - 1)) {
                queue.offer(pos - 1);
                grid[row][col - 1] = '3';
            }
        }
    }
}
