package org.khwu._132_palindrome_partitioning_ii;

import java.util.Arrays;

public class LE132MinCut {
    // ref: https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        for (int i = 0; i < len; i++) {
            for (int start = i, end = i; start >= 0 && end < len && s.charAt(start) == s.charAt(end); start--, end++) {
                dp[end+1] = Math.min(dp[start] + 1, dp[end+1]);
            }
            for (int start = i, end = i+1; start >= 0 && end < len && s.charAt(start) == s.charAt(end); start--, end++) {
                dp[end+1] = Math.min(dp[start] + 1, dp[end+1]);
            }
        }
        return dp[len];
    }
    // My
//    public int minCut(String s) {
//        int[] dp = new int[s.length()+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        boolean[][] pal = new boolean[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j <= i; j++) {
//                if (s.charAt(j) == s.charAt(i)) {
//                    if (i - j <= 2) pal[j][i] = true;
//                    else pal[j][i] = pal[j+1][i-1];
//                }
//                if (pal[j][i]) {
//                    if (j == 0) {
//                        dp[i+1] = 0;
//                    } else {
//                        dp[i+1] = Math.min(dp[i+1], dp[j] + 1);
//                    }
//                }
//            }
//        }
//        // System.out.println(Arrays.toString(dp));
//        return dp[s.length()];
//    }
}
