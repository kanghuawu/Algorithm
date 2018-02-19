package org.khwu;

import java.util.ArrayList;
import java.util.List;

public class LE051SolveNQueens {
    private int N;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        N = n;
        res = new ArrayList();
        dfs(0, new int[n]);
        return res;
    }

    private void dfs(int i, int[] queen) {
        if (i >= N) {
            res.add(convert(queen));
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

    private List<String> convert(int[] queen) {
        List<String> res = new ArrayList();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (queen[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
