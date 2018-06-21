package org.khwu._639_decode_ways_ii;

public class LE639NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        double[] dp = new double[n+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                if (i > 0) {
                    if (s.charAt(i-1) == '1') {
                        dp[i+1] += dp[i-1] * 9;
                    } else if (s.charAt(i-1) == '2') {
                        dp[i+1] += dp[i-1] * 6;
                    } else if (s.charAt(i-1) == '*') {
                        dp[i+1] += dp[i-1] * 15;
                    }
                }
                dp[i+1] += dp[i] * 9;
            } else {
                int num1 = (s.charAt(i) - '0');
                if (num1 >= 1 && num1 <= 9) {
                    dp[i+1] += dp[i];
                }
                if (i != 0) {
                    if (s.charAt(i-1) != '*') {
                        int num2 = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
                        if (num2 >= 10 && num2 <= 26) {
                            dp[i+1] += dp[i-1];
                        }
                    } else {
                        if (num1 <= 6) dp[i+1] += dp[i-1] * 2;
                        else dp[i+1] += dp[i-1];
                    }
                }

            }
            dp[i+1] = dp[i+1] % (Math.pow(10, 9) + 7);
        }
        return (int) dp[n];
    }
}
