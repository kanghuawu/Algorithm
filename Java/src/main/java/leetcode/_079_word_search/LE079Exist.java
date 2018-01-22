package leetcode._079_word_search;

public class LE079Exist {
    private int rowL;
    private int colL;
    public boolean exist(char[][] board, String word) {
        rowL = board.length;
        if (rowL == 0) return false;
        colL = board[0].length;
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                boolean[] visited = new boolean[rowL*colL];
                if (dfs(board, word, 0, visited, i, j)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int strIdx, boolean[] visited, int i, int j) {
        if (word.length() == strIdx) return true;
        if (i < 0 || i >= rowL || j < 0 || j >= colL || visited[i*colL + j] || word.charAt(strIdx) != board[i][j]) return false;

        visited[i*colL + j] = true;
        if (dfs(board, word, strIdx+1, visited, i-1, j) ||
                dfs(board, word, strIdx+1, visited, i+1, j) ||
                dfs(board, word, strIdx+1, visited, i, j-1) ||
                dfs(board, word, strIdx+1, visited, i, j+1)) return true;
        visited[i*colL + j] = false;
        return false;
    }
}
