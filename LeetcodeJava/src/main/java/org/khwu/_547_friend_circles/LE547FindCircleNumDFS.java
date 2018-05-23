package org.khwu._547_friend_circles;

public class LE547FindCircleNumDFS {
    public int fLE(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, visited, i, n);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int i, int n) {
        if (i < 0 || i >= n || visited[i]) return;

        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (!visited[j] && M[i][j] == 1) {
                dfs(M, visited, j, n);
            }
        }

    }
}
