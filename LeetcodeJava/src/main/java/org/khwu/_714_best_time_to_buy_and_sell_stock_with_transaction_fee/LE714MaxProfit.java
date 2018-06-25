package org.khwu._714_best_time_to_buy_and_sell_stock_with_transaction_fee;

public class LE714MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        int total = 0;
        for (int p : prices) {
            buy = Math.min(buy, p - sell);
            sell = Math.max(sell, p - buy - fee);
        }
        return sell;
    }
}
