package leetcode._785_is_graph_bipartite;

public class LE785IsBipartite {
    private boolean isBipartite = true;
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] color = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) dfs(graph, i, visited, color);
        }
        return isBipartite;
    }

    private void dfs(int[][] graph, int v, boolean[] visited, boolean[] color) {
        visited[v] = true;
        for (int i : graph[v]) {
            if (!visited[i]) {
                color[i] = !color[v];
                dfs(graph, i, visited, color);
            } else if (color[i] == color[v]) {
                isBipartite = false;
            }
        }
    }
}
