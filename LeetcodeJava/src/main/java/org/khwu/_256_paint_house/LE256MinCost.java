package org.khwu._256_paint_house;

public class LE256MinCost {
    public int minCost(int[][] costs) {
        int[] dp = new int[3];
        for (int[] cost : costs) {
            int r = dp[0];
            int g = dp[1];
            int b = dp[2];
            dp[0] = Math.min(cost[1] + g, cost[2] + b);
            dp[1] = Math.min(cost[0] + r, cost[2] + b);
            dp[2] = Math.min(cost[0] + r, cost[1] + g);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
