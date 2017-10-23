package leetcode;

public class LE122MaxProfit {
    // MY
    public int maxProfit(int[] prices) {
        int acc = 0;
        int local;
        for (int i = 1; i < prices.length; i++) {
            local = prices[i] - prices[i - 1];
            if (local > 0) {
                acc += local;
            }
        }
        return acc;
    }
}
