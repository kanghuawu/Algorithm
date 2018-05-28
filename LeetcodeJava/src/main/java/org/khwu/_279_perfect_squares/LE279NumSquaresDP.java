package org.khwu._279_perfect_squares;

import java.util.Arrays;

public class LE279NumSquaresDP {

    // MY ref: https://discuss.leetcode.com/topic/26400/an-easy-understanding-dp-solution-in-java
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int j = 1;
            while (i -  j * j >= 0) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }
}
