package org.khwu;

public class LE221MaximalSquare {
//    public int maximalSquare(char[][] matrix) {
//        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
//        int[][] dp = new int[rows + 1][cols + 1];
//        int maxsqlen = 0;
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= cols; j++) {
//                if (matrix[i-1][j-1] == '1'){
//                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
//                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
//                }
//            }
//        }
//        return maxsqlen * maxsqlen;
//    }
    
//    public int maximalSquare(char[][] matrix) {
//        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
//        int[] dp = new int[cols + 1];
//        int maxsqlen = 0, prev = 0;
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= cols; j++) {
//                int temp = dp[j];
//                if (matrix[i - 1][j - 1] == '1') {
//                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
//                    maxsqlen = Math.max(maxsqlen, dp[j]);
//                } else {
//                    dp[j] = 0;
//                }
//                prev = temp;
//            }
//        }
//        return maxsqlen * maxsqlen;
//    }
	
	public int maximalSquare(char[][] matrix) {
      int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
      int[] dp = new int[cols + 1];
      int maxsqlen = 0, prev = 0;
      for (int i = 1; i <= rows; i++) {
          for (int j = 1; j <= cols; j++) {
              int temp = dp[j];
              dp[j] = (Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1) * matrix[i - 1][j - 1];
              maxsqlen = Math.max(maxsqlen, dp[j]);
              prev = temp;
          }
      }
      return maxsqlen * maxsqlen;
  }
	
    public static void main(String[] args){
//		char[][] num1 = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//		LE221MaximalSquare test = new LE221MaximalSquare();
//		System.out.println(test.maximalSquare(num1));
    	int[] tt = new int[9];
    	System.out.println(tt[8]);
	}
}
