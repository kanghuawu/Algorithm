import edu.princeton.cs.algs4.MinPQ;
import java.util.LinkedList;
import java.util.Comparator;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solver {
    private MinPQ<Node> curPQ;
    private MinPQ<Node> twinPQ;
    private boolean isSolvable;
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null)
            throw new IllegalArgumentException();
        curPQ = new MinPQ<Node>();
        twinPQ = new MinPQ<Node>();

        curPQ.insert(new Node(initial, 0));
        twinPQ.insert(new Node(initial.twin(), 0));

        while (!curPQ.min().bd.isGoal() && !twinPQ.min().bd.isGoal()) {
            Node curMin = curPQ.delMin();
            for (Board nb : curMin.bd.neighbors()) {
                if (curMin.previous != null && nb.equals(curMin.previous.bd)) continue;
                Node nxtCurPQ = new Node(nb, curMin.moves + 1);
                curPQ.insert(nxtCurPQ);
                nxtCurPQ.previous = curMin;
            }

            Node twinMin = twinPQ.delMin();
            for (Board nb : twinMin.bd.neighbors()) {
                if (twinMin.previous != null && nb.equals(twinMin.previous.bd)) continue;
                Node nxtTwinPQ = new Node(nb, twinMin.moves + 1);
                twinPQ.insert(nxtTwinPQ);
                nxtTwinPQ.previous = twinMin;
            }
        }
        if (curPQ.min().bd.isGoal()) {
            isSolvable = true;
        }
    }

    private class Node implements Comparable<Node> {
        private Board bd;
        private Node previous;
        private int moves;
        private int priority;

        public Node(Board board, int moves) {
            this.bd = board;
            this.moves = moves;
            this.priority = moves + board.manhattan();
        }

        public boolean equals(Object that) {
            if (that == null) return false;
            if (that == this) return true;
            if (that.getClass() != this.getClass()) return false;

            Node node = (Node) that;
            return this.bd.equals(node.bd);
        }

        @Override
        public int compareTo(Node that) {
            if (that == null)
                throw new NullPointerException();

            if (this.priority < that.priority) 
                return -1;
            if (this.priority == that.priority) 
                return 0;
            return 1;
        }
    }
    
    /*
    private static class ByHamming implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if (a.bd.hamming() + a.moves < b.bd.hamming() + b.moves) 
                return -1;
            if (a.bd.hamming() + a.moves == b.bd.hamming() + b.moves)
                return 0;
            return 1;
        }
    }
    */

    // is the initial board solvable?
    public boolean isSolvable() {
        if (isSolvable)
            return true;
        return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (isSolvable)
            return curPQ.min().moves;
        return -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    
    public Iterable<Board> solution() {
        if (!isSolvable) return null;
        Deque<Board> res = new ArrayDeque<Board>();
        for (Node node = curPQ.min(); node != null; node = node.previous) {
            res.push(node.bd);
        }
        return res;
    }
    
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}