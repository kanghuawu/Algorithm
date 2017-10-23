package leetcode;

public class LE121MaxProfit {
    // MY
    public int maxProfit(int[] prices) {
        int min = 0;
        int max = 0;
        int maxValue = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
            }

            if (prices[i] - prices[min] > maxValue && i > min) {
                max = i;
                maxValue = prices[i] - prices[min];
            }
        }
        return maxValue;
    }
    // Kadane's Algorithm ref: https://discuss.leetcode.com/topic/19853/kadane-s-algorithm-since-no-one-has-mentioned-about-this-so-far-in-case-if-interviewer-twists-the-input
//    public int maxProfit(int[] prices) {
//        int maxCur = 0, maxSoFar = 0;
//        for(int i = 1; i < prices.length; i++) {
//            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
//            maxSoFar = Math.max(maxCur, maxSoFar);
//        }
//        return maxSoFar;
//    }
}
