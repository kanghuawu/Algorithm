package leetcode.LE200NumIslands;

import java.util.LinkedList;
import java.util.Queue;

public class LE200NumIslands {
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
//    public int numIslands(char[][] grid) {
//        int island = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    dfs(i, j, grid);
//                    island++;
//                }
//            }
//        }
//        return island;
//    }
//
//    private void dfs(int row, int col, char[][] grid) {
//        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
//            return;
//        }
//
//        if (grid[row][col] == '0' || grid[row][col] == '3') {
//            return;
//        }
//
//        if (grid[row][col] == '1') {
//            grid[row][col] = '3';
//        }
//
//        dfs(row - 1, col, grid);
//        dfs(row + 1, col, grid);
//        dfs(row, col - 1, grid);
//        dfs(row, col + 1, grid);
//    }

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

    // MY 2017-12-27 UF
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;

        WeightedQuickUion uf = new WeightedQuickUion(rowLen * colLen);

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    int pos = i * colLen + j;
                    if (isValid(i - 1, j, rowLen, colLen, grid) && !uf.connected(pos, pos - colLen)) {
                        uf.union(pos, pos - colLen);
                    }
                    if (isValid(i + 1, j, rowLen, colLen, grid) && !uf.connected(pos, pos + colLen)) {
                        uf.union(pos, pos + colLen);
                    }
                    if (isValid(i, j - 1, rowLen, colLen, grid) && !uf.connected(pos, pos - 1)) {
                        uf.union(pos, pos - 1);
                    }
                    if (isValid(i, j + 1, rowLen, colLen, grid) && !uf.connected(pos, pos + 1)) {
                        uf.union(pos, pos + 1);
                    }
                } else {
                    uf.count--;
                }
            }
        }
        return uf.count;
    }

    private boolean isValid(int i,int j, int rowLen, int colLen, char[][] grid) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || grid[i][j] != '1') {
            return false;
        }
        return true;
    }

    static class WeightedQuickUion {
        int[] parent;
        int count;
        int[] size;
        public WeightedQuickUion(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            size = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
            }
        }

        int find(int n) {
            while (n != parent[n]) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        void union(int n, int m) {
            int nParent = find(n);
            int mParent = find(m);
            if (nParent == mParent) {
                return;
            }
            if (size[mParent] > size[nParent]) {
                parent[nParent] = mParent;
                size[mParent] += size[nParent];
            } else {
                parent[mParent] = nParent;
                size[nParent] += size[mParent];
            }
            count--;
        }

        boolean connected(int n, int m) {
            return find(n) == find(m);
        }
    }
}
