package org.khwu._389_find_the_difference;

public class LE389FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--arr[t.charAt(i) - 'a'] < 0) return t.charAt(i);
        }
        return '-';
    }
}
