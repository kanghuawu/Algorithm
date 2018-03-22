package org.khwu._311_sparse_matrix_multiplication;

public class LE311Multiply {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int p = B.length;
        if (m == 0 || p == 0) return new int[0][0];
        int n = A[0].length;
        int q = B[0].length;
        int[][] res = new int[m][q];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;
                for (int k = 0; k < q; k++) {
                    if (B[j][k] == 0) continue;
                    res[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return res;
    }
}
