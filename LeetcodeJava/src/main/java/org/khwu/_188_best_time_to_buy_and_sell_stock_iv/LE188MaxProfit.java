package org.khwu._188_best_time_to_buy_and_sell_stock_iv;

public class LE188MaxProfit {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] - prices[i-1] > 0)
                    res += prices[i] - prices[i-1];
            }
            return res;
        }
        int[][] trans = new int[k+1][n+1];
        for (int i = 0; i < k; i++) {
            int buy = Integer.MIN_VALUE;
            int sell = 0;
            for (int j = 0; j < n; j++) {
                buy = Math.max(buy, trans[i][j] - prices[j]);
                sell = Math.max(sell, prices[j] + buy);
                trans[i+1][j+1] = Math.max(trans[i+1][j], sell);
            }
        }
        // for (int[] inn : trans)
        //     System.out.println(Arrays.toString(inn));
        return trans[k][n];
    }
}
