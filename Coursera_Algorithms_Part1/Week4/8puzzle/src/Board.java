import java.util.LinkedList;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class Board {
    private final int size;
    private final int size2D;
    private int hammingNum;
    private int manhattanNum;
    private final int[] blocksCp;
    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        if (blocks == null)
            throw new IllegalArgumentException();
        this.size = blocks.length;
        this.size2D = this.size * this.size;
        this.blocksCp = new int[this.size2D];
        
        hammingNum = 0;
        manhattanNum = 0;

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int pos = twoDimToOneDim(i, j);
                this.blocksCp[pos] = blocks[i][j];
                
                int currNum = this.blocksCp[pos] - 1;
                if (pos != currNum && this.blocksCp[pos] != 0) {
                    hammingNum++;
                    int x = oneDimToTwoDim(currNum)[0];
                    int y = oneDimToTwoDim(currNum)[1];
                    manhattanNum += Math.abs(y - j) + Math.abs(x - i);
                }
            }
        }
    }

    private int twoDimToOneDim(int i, int j) {
        return this.size * i + j;
    }

    private int[] oneDimToTwoDim(int i) {
        int[] pos = new int[2];
        pos[0] = i / this.size;
        pos[1] = i % this.size;
        return pos;
    }

    // board dimension n
    public int dimension() {
        return this.size;
    }

    // number of blocks out of place
    public int hamming() {
        return hammingNum;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        return manhattanNum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hammingNum == 0 && manhattanNum == 0;
    }
    
    private int[][] createTwoDimArray(int[] oneDimArr, int length) {
        int[][] twoDimArr = new int[length][length];
        for (int i = 0; i < length; i++) 
            for (int j = 0; j < length; j++) 
                twoDimArr[i][j] = oneDimArr[twoDimToOneDim(i, j)];
        return twoDimArr;
    }
    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        int[][] twinBlocks = createTwoDimArray(this.blocksCp, this.size);
        
        Board twinBoard = new Board(twinBlocks);
        int first;
        int second;
        do {
            first = StdRandom.uniform(this.size2D);
            second = StdRandom.uniform(this.size2D);
        } while (first == second || this.blocksCp[first] == 0 || this.blocksCp[second] == 0);
        swap(twinBoard.blocksCp, first, second);
        return twinBoard;
    }

    private void swap(int[] blocks, int i, int j) {
        int temp = blocks[i];
        blocks[i] = blocks[j];
        blocks[j] = temp;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;

        Board that = (Board) y;
        if (this.size != that.size) return false;
        for (int i = 0; i < this.size2D; i++) {
            if (this.blocksCp[i] != that.blocksCp[i]) return false;
        }
        return true;
    }
    // all neighboring boards
    public Iterable<Board> neighbors() {
        LinkedList<Board> it = new LinkedList<Board>();
        int zero = 0;
        int[] neighborBlocks = new int[this.size2D];
        for (int i = 0; i < this.size2D; i++) {
            neighborBlocks[i] = this.blocksCp[i];
            if (this.blocksCp[i] == 0) zero = i;
        }
        int zeroX = oneDimToTwoDim(zero)[0];
        int zeroY = oneDimToTwoDim(zero)[1];
        if (zeroY != 0) {
            swap(neighborBlocks, zero, zero - 1);
            it.add(new Board(createTwoDimArray(neighborBlocks, this.size)));
            swap(neighborBlocks, zero, zero - 1);
        }

        if (zeroY != this.size - 1) {
            swap(neighborBlocks, zero, zero + 1);
            it.add(new Board(createTwoDimArray(neighborBlocks, this.size)));
            swap(neighborBlocks, zero, zero + 1);
        }

        if (zeroX != 0) {
            swap(neighborBlocks, zero, zero - this.size);
            it.add(new Board(createTwoDimArray(neighborBlocks, this.size)));
            swap(neighborBlocks, zero, zero - this.size);
        }

        if (zeroX != this.size - 1) {
            swap(neighborBlocks, zero, zero + this.size);
            it.add(new Board(createTwoDimArray(neighborBlocks, this.size)));
            swap(neighborBlocks, zero, zero + this.size);
        }

        return it;
    }
    
    // string representation of this board (in the output format specified below)
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(this.size + "\n");
        for (int i = 0, k = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                res.append(String.format("%2d ", this.blocksCp[k++]));
            }
            res.append('\n');
        }
        return res.toString();
    }
    // unit tests (not graded)
    public static void main(String[] args) {
        int size = 3;
        int[][] blocks = new int[size][size];
        for (int i = 0, k = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                blocks[i][j] = k;
                k++;
            }
        }
        Board boardA = new Board(blocks);
        StdOut.println("Board A...");
        StdOut.println("To String...");
        StdOut.println(boardA.toString());
        StdOut.println("Hamming...");
        StdOut.println(boardA.hamming());
        StdOut.println("Manhattan...");
        StdOut.println(boardA.manhattan());
        StdOut.println("Dimension...");
        StdOut.println(boardA.dimension());
        StdOut.println("To String...");
        StdOut.println(boardA.toString());
        StdOut.println("Twin...");
        StdOut.println(boardA.twin().toString());
        StdOut.println("Neighbor...");
        for (Board neighbor : boardA.neighbors()) {
            StdOut.println(neighbor.toString());
        }

        StdOut.println("==========================");
        for (int[] inner : blocks) {
            StdRandom.shuffle(inner);
        }

        Board boardB = new Board(blocks);
        StdOut.println("Board B...");
        StdOut.println("To String...");
        StdOut.println(boardB.toString());
        StdOut.println("Hamming...");
        StdOut.println(boardB.hamming());
        StdOut.println("Manhattan...");
        StdOut.println(boardB.manhattan());
        StdOut.println("Dimension...");
        StdOut.println(boardB.dimension());
        StdOut.println("Twin...");
        StdOut.println(boardB.twin().toString());
        StdOut.println("Neighbor...");
        for (Board neighbor : boardB.neighbors()) {
            StdOut.println(neighbor.toString());
        }

        StdOut.println("==========================");

        int[] arrC = new int[size * size];
        for (int i = 0; i < size * size; i++) {
            arrC[i] = i;
        }
        StdRandom.shuffle(arrC);
        for (int i = 0, k = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                blocks[i][j] = arrC[k];
                k++;
            }
        }

        Board boardC = new Board(blocks);
        StdOut.println("Board B...");
        StdOut.println("To String...");
        StdOut.println(boardC.toString());
        StdOut.println("Hamming...");
        StdOut.println(boardC.hamming());
        StdOut.println("Manhattan...");
        StdOut.println(boardC.manhattan());
        StdOut.println("Dimension...");
        StdOut.println(boardC.dimension());
        StdOut.println("Twin...");
        StdOut.println(boardC.twin().toString());
        StdOut.println("Neighbor...");
        for (Board neighbor : boardC.neighbors()) {
            StdOut.println(neighbor.toString());
        }
    }
}