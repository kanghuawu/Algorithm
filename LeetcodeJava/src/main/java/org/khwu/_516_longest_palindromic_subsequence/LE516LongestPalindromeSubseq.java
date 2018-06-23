package org.khwu._516_longest_palindromic_subsequence;

public class LE516LongestPalindromeSubseq {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += helper(s, i, i);
            res += helper(s, i, i+1);
        }
        return res;
    }

    private int helper(String s, int i, int j) {
        int count = 0;
        for (; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
            count++;
        }
        return count;
    }
}
