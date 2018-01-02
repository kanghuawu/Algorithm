package leetcode._747_min_cost_climbing_stairs;

public class LE747MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int dp0 = cost[0];
        int dp1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            if (i % 2 == 0) {
                dp0 = Math.min(dp0, dp1) + cost[i];
            } else {
                dp1 = Math.min(dp0, dp1) + cost[i];
            }
        }
        return Math.min(dp0, dp1);
    }
}
