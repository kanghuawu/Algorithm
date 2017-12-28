package notebook;

public class UF {
    class QuickFind {
        private int[] parent;
        private int count;
        public QuickFind(int n) {
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            return parent[node];
        }

        public void union(int n, int m) {
            if (n < 0|| m < 0 || n >= parent.length || m >= parent.length) {
                return;
            }
            int nParent = parent[n];
            int nParent = parent[n];
            for (int i = 0; i < parent.length; i++) {

            }
        }
    }
}
