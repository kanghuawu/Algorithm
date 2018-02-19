package org.khwu;

import java.util.Arrays;

public class LE375GetMoneyAmount {

//    public int getMoneyAmount(int n) {
//        int[] dp = new int[n+1];
//
//        for (int i = 2; i <= n; i++) {
//            int j = i-1;
//            int min = Integer.MAX_VALUE;
//            int sum = 0;
//            int k = 1;
//            while (j > 0) {
//                sum += j;
//                min = Math.min(Math.max(sum, j+dp[j-1]), min);
//                j -= (int)Math.pow(2, k);
//                k++;
//            }
//            dp[i] = min;
//        }
//        return dp[n];
//    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                int min = Integer.MAX_VALUE;
                for (int k = j + 1; k < i; k++) {
                    int max = k + Math.max(dp[j][k - 1], dp[k + 1][i]);
                    min = Math.min(max, min);
                }
                if (j == i - 1) {
                    min = j;
                }
//                System.out.println(j);
                dp[j][i] = min;
            }
        }
//        for (int[] arr : dp) {
//            System.out.println(Arrays.toString(arr));;
//        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        LE375GetMoneyAmount test = new LE375GetMoneyAmount();
        System.out.println(test.getMoneyAmount(6));
    }
}
