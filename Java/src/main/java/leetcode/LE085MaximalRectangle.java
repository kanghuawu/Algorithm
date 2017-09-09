package leetcode;

import java.util.Arrays;

public class LE085MaximalRectangle {
//    public int maximalRectangle(char[][] matrix) {
//        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
//        int[][] dp_v = new int[rows + 1][cols + 1];
//        int[][] dp_h = new int[rows + 1][cols + 1];
//        int maxrec = 0;
//        int singlemax = 0;
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= cols; j++) {
//            	if(matrix[i - 1][j - 1] == '1'){
//            		singlemax += 1;
////            		System.out.println(singlemax);
//            		if(dp_h[i-1][j-1] == 0){
//            			dp_h[i][j] = 1;
//            		}else{
//            			dp_h[i][j] = dp_h[i][j - 1] + 1;
//            		}
//            	}else{
//            		maxrec = Math.max(maxrec, singlemax);
//            		singlemax = 0;
//            		dp_h[i][j] = 0;
//            	}
//            	
//            }
//            maxrec = Math.max(maxrec, singlemax);
//    		singlemax = 0;
//        }
//        for (int j = 1; j <= cols; j++) {
//        	for (int i = 1; i <= rows; i++){
//        		if(matrix[i - 1][j - 1] == '1'){
//        			singlemax += 1;
//            		if(dp_v[i-1][j-1] == 0){
//            			dp_v[i][j] = 1;
//            		}else{
//            			dp_v[i][j] = dp_v[i - 1][j] + 1;
//            		}
//            	}else{
//            		maxrec = Math.max(maxrec, singlemax);
//            		singlemax = 0;
//            		dp_v[i][j] = 0;
//            	}
//        	}
//        	maxrec = Math.max(maxrec, singlemax);
//    		singlemax = 0;
//        }
//        
//        for(int i = 0; i <= rows; i++){
//        	for(int j = 0; j <= cols; j++){
////        		System.out.print(dp_v[i][j]);
//        		maxrec = Math.max(maxrec, dp_h[i][j] * dp_v[i][j]);
//        	}
////        	System.out.print('\n');
//        }
//        
//        return maxrec;
//    }
    
    public int maximalRectangle(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return 0; }
    	int rows = matrix.length, cols = matrix[0].length;
    	int[] left = new int[cols], right = new int[cols], top = new int[cols];
    	Arrays.fill(left, cols); // max distance (inclusive) to left-most 1 at (y,x)
    	Arrays.fill(right, cols); // max distance (inclusive) to right-most 1 at (y,x)
    	Arrays.fill(top, 0); // max distance (inclusive) to top-most 1 at (y,x)
    	int max = 0;
    	for (int y = 0; y < rows; y++) {
    		for (int x = 0; x < cols; x++) {
    			if (matrix[y][x] == '1') { top[x] += 1; }
    			else { top[x] = 0; }
    		}
    		int l = 0; // max left distance so far
    		for (int x = 0; x < cols; x++) {
    			if (matrix[y][x] == '1') { left[x] = Math.min(left[x], ++l); }
    			else { left[x] = cols; l = 0; }
    		}
    		int r = 0; // max right distance so far
    		for (int x = cols-1; x >= 0; x--) {
    			if (matrix[y][x] == '1') { right[x] = Math.min(right[x], ++r); }
    			else { right[x] = cols; r = 0; }
    		}
    		for (int x = 0; x < cols; x++) {
    			if (matrix[y][x] == '1') {
    				// width should exclude double count of current element
    				max = Math.max(max, (left[x]+right[x]-1)*top[x]);
    			}
    		}
    	}
    	return max;
    }
    
    public static void main(String[] args){
		char[][] num = {{'1', '1', '1', '1'}, {'1', '1', '1', '1'}, {'1', '1', '1', '1'}};
		char[][] num1 = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
		char[][] num2 = {{'1', '1'}};
		LE085MaximalRectangle test = new LE085MaximalRectangle();
		System.out.println(test.maximalRectangle(num2));
	}
}
