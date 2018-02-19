package org.khwu;

public class LE052TotalNQueens {
    private int N;
    private int res;
    public int totalNQueens(int n) {
        N = n;
        res = 0;
        dfs(0, new int[n]);
        return res;
    }

    private void dfs(int i, int[] queen) {
        if (i >= N) {
            res++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (valid(i, j, queen)) {
                queen[i] = j;
                dfs(i + 1, queen);
            }
        }
    }

    private boolean valid(int i, int j, int[] queen) {
        for (int row = 0; row < i; row ++) {
            if (queen[row] == j || Math.abs(row - i) ==  Math.abs(queen[row] - j)) {
                return false;
            }
        }
        return true;
    }
}
