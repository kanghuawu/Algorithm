package org.khwu._311_sparse_matrix_multiplication;

import java.util.HashMap;
import java.util.Map;

public class LE311MultiplyHashMap {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int p = B.length;
        if (m == 0 || p == 0) return new int[0][0];
        int n = A[0].length;
        int q = B[0].length;
        int[][] res = new int[m][q];

        Map<Integer, Map<Integer, Integer>> tA = new HashMap<>();
        for (int i = 0; i < m; i++) {
            tA.put(i, new HashMap<>());
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;
                tA.get(i).put(j, A[i][j]);
            }
        }

        Map<Integer, Map<Integer, Integer>> tB = new HashMap<>();
        for (int i = 0; i < p; i++) {
            tB.put(i, new HashMap<>());
            for (int j = 0; j < q; j++) {
                if (B[i][j] == 0) continue;
                tB.get(i).put(j, B[i][j]);
            }
        }

        for (int i : tA.keySet()) {
            for (int j : tA.get(i).keySet()) {
                for (int k : tB.getOrDefault(j, new HashMap<>()).keySet()) {
                    res[i][k] += tA.get(i).get(j) * tB.get(j).get(k);
                }
            }
        }

        return res;
    }
}
