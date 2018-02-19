package org.khwu;

import java.util.Arrays;

public class LE091NumDecodings {
    // MY Time exceed limit
//    private int count;
//    public int LE091NumDecodings(String s) {
//        if (s.length() == 0) return 0;
//        count = 0;
//        dfs(s, 0);
//        return count;
//    }
//    private void dfs(String s, int idx) {
//        if (idx >= s.length() ) {
//            count++;
//            return;
//        }
//        if (idx + 1 < s.length()
//                && Integer.parseInt(s.substring(idx, idx + 2)) <= 26
//                && Integer.parseInt(s.substring(idx, idx + 2)) >= 10)
//            dfs(s, idx + 2);
//        if (s.charAt(idx) != '0')
//            dfs(s, idx + 1);
//    }
    // ref: https://discuss.leetcode.com/topic/35840/java-clean-dp-solution-with-explanations
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            int one = Integer.parseInt(s.substring(i- 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one >= 1 && one <= 9)
                dp[i] += dp[ i - 1];
            if (two >= 10 && two <= 26)
                dp[i] += dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
