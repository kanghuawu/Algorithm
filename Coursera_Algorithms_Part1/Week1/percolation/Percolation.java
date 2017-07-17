import edu.princeton.cs.algs4.WeightedQuickUnionUF;

// public class Percolation {
    
//     private final int n;
//     private int open;
//     private boolean[][] grid;
//     private final WeightedQuickUnionUF wqufPerc;
//     private final WeightedQuickUnionUF wqufFull;
//     private final int upper;
//     private final int bottom;
//     // create n-by-n grid, with all sites blocked
//     public Percolation(int n) {
//         if (n <= 0)
//             throw new IllegalArgumentException(Integer.toString(n));
//         this.n = n;
//         open = 0;
//         grid = new boolean[n][n];
//         wqufPerc = new WeightedQuickUnionUF(n*n + 2);
//         wqufFull = new WeightedQuickUnionUF(n*n + 1);
//         upper = 0;
//         bottom = n*n+1;
//     }
    
//     // open site (row, col) if it is not open already
//     public void open(int row, int col){
//         checkValidePosition(row, col);
//         if (!isOpen(row, col)) {
//             grid[row-1][col-1] = true;
//             int wqufPosition = changeWQUFPosition(row, col);
//             // union firt row with upper
//             if(row == 1){
//                 wqufPerc.union(wqufPosition, upper);
//                 wqufFull.union(wqufPosition, upper);
//             }
//             // union last row with bottom
//             if(row == n)
//                 wqufPerc.union(wqufPosition, bottom);

//             tryConnect(row, col-1, wqufPosition);
//             tryConnect(row, col+1, wqufPosition);
//             tryConnect(row-1, col, wqufPosition);
//             tryConnect(row+1, col, wqufPosition);
//             open++;
//         }
//     }

//     private int changeWQUFPosition(int row, int col){
//         return (row-1)*this.n + col;
//     }
//     private void tryConnect(int row, int col, int wqufPosition){
//         try {
//             if (isOpen(row, col)){
//                 wqufPerc.union(changeWQUFPosition(row, col), wqufPosition);
//                 wqufFull.union(changeWQUFPosition(row, col), wqufPosition);
//             }

//         } catch(IllegalArgumentException e) {}
//     }
    
//     // is site (row, col) open?
//     public boolean isOpen(int row, int col){
//         checkValidePosition(row, col);
//         return grid[row-1][col-1];
//     }

//     // is site (row, col) full?
//     public boolean isFull(int row, int col){
//         checkValidePosition(row, col);
//         return wqufFull.connected(upper, changeWQUFPosition(row, col));
//     }
    
//     // number of open sites
//     public int numberOfOpenSites(){
//         return open;
//     }
    
//     // does the system percolate?
//     public boolean percolates(){
//         return wqufPerc.connected(upper, bottom);
//     }
    
//     private void checkValidePosition(int row, int col){
//         if (row <= 0 || row > n)
//             throw new IllegalArgumentException("row: " + Integer.toString(row));
//         else if (col <= 0 ||  col > n)
//             throw new IllegalArgumentException("col: " + Integer.toString(col));
//     }
    
//     // test client (optional)
//     public static void main(String[] args){
        
//     }
// }

