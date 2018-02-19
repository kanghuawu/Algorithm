package p21_wordnet;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;

public class SAP {

    private final Digraph graph;
    // constructor takes a rooted DAG as argument
    public SAP(Digraph G) {
        if (G == null) {
            throw new IllegalArgumentException();
        }
        graph = new Digraph(G);
    }

    private int[] findAncestorAndLength(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths bfdpV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfdpW = new BreadthFirstDirectedPaths(graph, w);
        int shortest = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int nb = 0; nb < graph.V(); nb++) {
            if (bfdpV.hasPathTo(nb) && bfdpW.hasPathTo(nb)) {
                int len = bfdpV.distTo(nb) + bfdpW.distTo(nb);
                if (shortest > len) {
                    shortest = len;
                    ancestor = nb;
                }
            }
        }
        if (shortest == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{shortest, ancestor};
    }

    // length of shortest ancestral path between v and w
    public int length(int v, int w) {
        List<Integer> lv = new ArrayList<Integer>();
        lv.add(v);
        List<Integer> lw = new ArrayList<Integer>();
        lw.add(w);
        return length(lv, lw);
    }

    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w) {
        List<Integer> lv = new ArrayList<Integer>();
        lv.add(v);
        List<Integer> lw = new ArrayList<Integer>();
        lw.add(w);
        return ancestor(lv, lw);
    }

    // length of shortest ancestral path of vertex subsets A and B
    public int length(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        if (!isValid(subsetA, subsetB)) {
            throw new IndexOutOfBoundsException();
        }
        return findAncestorAndLength(subsetA, subsetB)[0];
    }

    // a shortest common ancestor of vertex subsets A and B
    public int ancestor(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        if (!isValid(subsetA, subsetB)) {
            throw new IndexOutOfBoundsException();
        }
        return findAncestorAndLength(subsetA, subsetB)[1];
    }

    private boolean isValid(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        for (int numA : subsetA) {
            if (numA >= graph.V() || numA < 0) {
                return false;
            }
        }
        for (int numB : subsetB) {
            if (numB >= graph.V() || numB < 0) {
                return false;
            }
        }
        return true;
    }

    // do unit testing of this class
    public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph G = new Digraph(in);
    SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length   = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}