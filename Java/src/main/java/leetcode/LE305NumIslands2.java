package leetcode;

public class LE305NumIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> res = new ArrayList<>();
        WeightedQuickUion uf = new WeightedQuickUion(m * n);

        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '0';
            }
        }

        for (int[] posArr : positions) {
            int i = posArr[0];
            int j = posArr[1];
            if (grid[i][j] == '0') {
                int pos = i * n + j;
                grid[i][j] = '1';
                uf.count++;
                if (isValid(i - 1, j, m, n, grid) && !uf.connected(pos, pos - n)) {
                    uf.union(pos, pos - n);
                }
                if (isValid(i + 1, j, m, n, grid) && !uf.connected(pos, pos + n)) {
                    uf.union(pos, pos + n);
                }
                if (isValid(i, j - 1, m, n, grid) && !uf.connected(pos, pos - 1)) {
                    uf.union(pos, pos - 1);
                }
                if (isValid(i, j + 1, m, n, grid) && !uf.connected(pos, pos + 1)) {
                    uf.union(pos, pos + 1);
                }
            }
            res.add(uf.count);
        }
        return res;
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
            count = 0;
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
