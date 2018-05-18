package org.khwu._125_valid_palindrome;

public class LE125IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 32;
            }
            if (!isLowerCharOrNumeric(arr[i])) {
                i++;
                continue;
            }
            if (arr[j] >= 'A' && arr[j] <= 'Z') {
                arr[j] += 32;
                continue;
            }
            if (!isLowerCharOrNumeric(arr[j])) {
                j--;
                continue;
            }
            if (i < j && arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isLowerCharOrNumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
