package leetcode;

public class LE074SearchMatrix {
//    public boolean searchMatrix(int[][] matrix, int target) {
//    	int rows = matrix.length;
//    	int cols = matrix[0].length;
//    	int start = 0;
//    	int end = cols * rows - 1;
//    	while(start <= end){
//    		System.out.println("start end: " + start + " " + end);
//    		int mid_row = ((start + end) / 2 ) / cols;
//    		int mid_col = ((start + end) / 2 ) % cols;
//    		System.out.println("mid row col: " + mid_row + " " + mid_col);
//    		int mid = matrix[mid_row][mid_col];
//    		System.out.println("mid: " + mid);
//    		if(mid == target ){
//    			return true;
//    		}else if(mid < target){
//    			start = (start + end) / 2 + 1;
//    		}else if(mid > target){
//    			end = (start + end) / 2 - 1;
//    		}
//    	}
//    	return false;
//    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
        
        return false;
    }
    /*
     * Use binary search for matrix[i][0] to find the row where target is in, and then 
     * use binary search for matrix[row][j] to find target. This solution is better because 
     * it avoids multiplication overflow(height*width) and / and % while it's complexity 
     * is the same as solution1.
     */
    public static void main(String[] args){
    	int[][] m = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
//    	int[][] m = {{1}};
//    	int[][] m = {{}};
    	int t = 1;
//    	System.out.print(3/2);
    	LE074SearchMatrix test = new LE074SearchMatrix();
    	System.out.print(test.searchMatrix(m, t));
    }
}
