package org.khwu._005_longest_palindromic_substring;

public class LE005LongestPalindromeDP {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = -1;
        int len = 0;
        int n = s.length();
        if (n == 0) return "";
        boolean[] dp = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[j - 1]);
                if (dp[j] && j - i > end - start) {
                    end = j;
                    start = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
