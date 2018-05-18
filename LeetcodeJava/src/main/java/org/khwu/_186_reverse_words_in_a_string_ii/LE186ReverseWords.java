package org.khwu._186_reverse_words_in_a_string_ii;

public class LE186ReverseWords {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) return;
        int n = str.length;
        reverse(str, 0, n-1);

        for (int i = 0, s = 0; i < n; i++) {
            if (str[i] == ' ') {
                reverse(str, s, i - 1);
                s = i + 1;
            } else if (i == n - 1) {
                reverse(str, s, i);
            }
        }
    }

    private void reverse(char[] str, int s, int e) {
        while (s < e) {
            char tmp = str[s];
            str[s] = str[e];
            str[e] = tmp;
            s++;
            e--;
        }
    }
}
