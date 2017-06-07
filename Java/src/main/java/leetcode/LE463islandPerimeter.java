package leetcode;

public class LE463islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int side = 0;
    	for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
        		if(grid[i][j] == 1) {
        			side += 4;
        			if(i > 0 && grid[i - 1][j] == 1) side -= 2;
            		if(j > 0 && grid[i][j - 1] == 1) side -= 2;
        		}
        		
//        		System.out.println("i: " + i + ", j: " + j + " side, " + side);
        	}
        }
    	return side;
    }
    public static void main(String[] arg){
    	int[][] x = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    	LE463islandPerimeter test = new LE463islandPerimeter();
    	System.out.println(test.islandPerimeter(x));
    }
}
