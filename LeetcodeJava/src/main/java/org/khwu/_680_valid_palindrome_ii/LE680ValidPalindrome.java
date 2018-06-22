package org.khwu._680_valid_palindrome_ii;

public class LE680ValidPalindrome {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0, j = n-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return helper(s, i+1, j) || helper(s, i, j-1);
        }
        return true;
    }

    private boolean helper(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
