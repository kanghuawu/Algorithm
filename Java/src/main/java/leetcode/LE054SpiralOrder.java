package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LE054SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) return res;
        spiralOrderHelper(matrix, res, 0, 0, matrix.length - 1, matrix[0].length - 1);
        return res;
    }
    private void spiralOrderHelper(int[][] matrix, List<Integer> res, int xStart, int yStart, int xEnd, int yEnd) {
        if (xStart > xEnd || yStart > yEnd) return;

        for (int i = yStart; i <= yEnd; i++)
            res.add(matrix[xStart][i]);

        for (int j = xStart + 1; j <= xEnd - 1; j++)
            res.add(matrix[j][yEnd]);
        if (xStart != xEnd)
            for (int k = yEnd; k >= yStart; k--)
                res.add(matrix[xEnd][k]);

        if (yStart != yEnd)
            for (int m = xEnd - 1; m >= xStart + 1; m--)
                res.add(matrix[m][yStart]);

        spiralOrderHelper(matrix, res, xStart + 1, yStart + 1, xEnd - 1, yEnd - 1);
    }
}
