package leetcode;

public class LE005LongestPalindrome {
    // MY
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        int max = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expand(s, i - 1, i + 1);
            int even = expand(s, i, i + 1);
            int temp = Math.max(odd, even);
            if (temp > max) {
                max = temp;
                idx = i;
            }
        }
        if (max % 2 == 1)
            return s.substring(idx - max / 2, idx + max / 2 + 1);
        else
            return s.substring(idx - max / 2 + 1, idx + max / 2 + 1);
    }
    private int expand(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1) {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        return end - start - 1;
    }


}
