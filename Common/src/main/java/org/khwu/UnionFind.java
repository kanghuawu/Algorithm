package org.khwu;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    static abstract class UF {
        int[] parent;
        int count;
        UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        abstract int find(int n);
        abstract void union(int n, int m);
        abstract boolean connected(int n, int m);
        void validate(int n) {
            if (n < 0 || n >= parent.length) {
                throw new IllegalArgumentException(""+ n);
            }
        }
    }

    static class QuickFind extends UF {
        public QuickFind(int n) {
            super(n);
        }

        @Override
        public int find(int n) {
            validate(n);
            return parent[n];
        }

        @Override
        public void union(int n, int m) {
            validate(n);
            validate(m);
            int nParent = parent[n];
            int mParent = parent[m];
            if (nParent == mParent) {
                return;
            }
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == nParent) {
                    parent[i] = mParent;
                }
            }
            count--;
        }

        @Override
        public boolean connected(int n, int m) {
            validate(n);
            validate(m);
            return parent[n] == parent[m];
        }
    }

    static class QuickUnion extends UF {
        public QuickUnion(int n) {
            super(n);
        }

        @Override
        public int find(int n) {
            validate(n);
            while (n != parent[n]) {
                n = find(parent[n]);
            }
            return n;
        }

        @Override
        public void union(int n, int m) {
            validate(n);
            validate(m);
            int nParent = find(n);
            int mParent = find(m);
            if (nParent == mParent) {
                return;
            }
            parent[nParent] = mParent;
            count--;
        }

        @Override
        public boolean connected(int n, int m) {
            validate(n);
            validate(m);
            return find(n) == find(m);
        }
    }

    static class WeightedQuickUion extends UF {

        private int[] size;
        public WeightedQuickUion(int n) {
            super(n);
            size = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
            }
        }

        @Override
        int find(int n) {
            validate(n);
            while (n != parent[n]) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        @Override
        void union(int n, int m) {
            validate(n);
            validate(m);
            int nParent = find(n);
            int mParent = find(m);
            if (nParent == mParent) {
                return;
            }
            if (size[mParent] > size[nParent]) {
                parent[nParent] = mParent;
                size[mParent] += size[nParent];
            } else {
                parent[mParent] = nParent;
                size[nParent] += size[mParent];
            }
            count--;
        }

        @Override
        boolean connected(int n, int m) {
            validate(n);
            validate(m);
            return find(n) == find(m);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("" + args.length);
        }
        In in = new In(args[1]);
        int n = in.readInt();

        UF uf;
        String name = args[0];
        if (name.equals("QuickFind")) {
            uf = new QuickFind(n);
        } else if (name.equals("QuickUnion")) {
            uf = new QuickUnion(n);
        } else {
            uf = new WeightedQuickUion(n);
        }
        while (in.hasNextLine()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
//            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count + " components");

    }
}
