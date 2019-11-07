package org.khwu.notebook.graph;

import edu.princeton.cs.algs4.Bag;

import java.util.Iterator;

public class Digraph {

    private Bag<Integer>[] adj;
    private int size;

    public Digraph(int n) {
        this.size = n;
        this.adj = new Bag[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Bag();
        }
    }

    public void addEdge(int n, int m) {
        adj[n].add(m);
    }

    public Iterator<Integer> adj(int i) {
        return adj(i);
    }
}
