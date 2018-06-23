package org.khwu._516_longest_palindromic_subsequence;

public class LE516LongestPalindromeSubseqDP {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i-1][j+1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i-1][j]);
                }
            }
        }

        return dp[s.length()-1][0];
    }
}
