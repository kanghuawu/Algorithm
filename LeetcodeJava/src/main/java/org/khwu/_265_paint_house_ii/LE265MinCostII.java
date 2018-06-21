package org.khwu._265_paint_house_ii;

public class LE265MinCostII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int sum1 = 0;
        int sum2 = 0;
        int minIdx = -1;
        int n = costs[0].length;
        for (int[] cost : costs) {
            int tmpIdx = 0;
            int tmpSum1 = Integer.MAX_VALUE;
            int tmpSum2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int c = cost[j] + (j == minIdx ?  sum2 : sum1);
                if (c < tmpSum1) {
                    tmpSum2 = tmpSum1;
                    tmpSum1 = c;
                    tmpIdx = j;
                } else if (c < tmpSum2) {
                    tmpSum2 = c;
                }
            }
            minIdx = tmpIdx;
            sum1 = tmpSum1;
            sum2 = tmpSum2;
        }
        return Math.min(sum1, sum2);
    }
}
