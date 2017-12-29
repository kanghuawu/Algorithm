package leetcode._200numislands;

public class LE200NumIslandsUF {
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
