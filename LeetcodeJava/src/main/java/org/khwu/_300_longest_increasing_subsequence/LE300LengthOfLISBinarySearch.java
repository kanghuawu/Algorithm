package org.khwu._300_longest_increasing_subsequence;

import java.util.Arrays;

public class LE300LengthOfLISBinarySearch {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] buf = new int[nums.length];
        Arrays.fill(buf, Integer.MAX_VALUE);
        int res = 0;
        for (int n : nums) {
            int idx = Arrays.binarySearch(buf, n);
            if (idx < 0) {
                int i;
                if (idx == -1) i = 0;
                else i = -1 * idx - 1;
                res = Math.max(i, res);
                buf[i] = n;
            }
        }
        return res + 1;
    }
}
