package org.khwu._806_number_of_lines_to_write_string;

public class LE806NumberOfLines {
}

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        char[] arr = S.toCharArray();
        int n = arr.length;
        int[] res = new int[]{1, 0};
        for (int i = 0; i < n; i++) {
            char ch = arr[i];
            res[1] += widths[ch - 'a'];
            if (res[1] > 100) {
                res[0]++;
                res[1] = widths[ch - 'a'];
            }
        }
        return res;
    }
}