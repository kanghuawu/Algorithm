package org.khwu._261_graph_valid_tree;

public class LE261ValidTreeUF {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (uf.connected(e[0], e[1])) return false;
            uf.union(e[0], e[1]);
        }
        return uf.count == 1;
    }

    private static class UF {
        int[] parent;
        int[] size;
        int count;
        public UF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int node) {
            while (node != parent[node]) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }

        public void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if (parent1 == parent2) return;

            if (size[parent1] > size[parent2]) {
                parent[node2] = parent1;
                size[node1] += size[node2];
            } else {
                parent[node1] = parent2;
                size[node2] += size[node1];
            }
            count--;
        }

        public boolean connected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }
}
