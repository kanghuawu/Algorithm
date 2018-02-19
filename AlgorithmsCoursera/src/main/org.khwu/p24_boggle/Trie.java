package p24_boggle;

import java.util.Set;

public class Trie {
    private Node root;
    private int rowL = -1;
    private int colL = -1;
    private class Node {
        char ch;
        boolean isWord;
        Node left, mid, right;
    }
    Trie() {}

    public void setRowL(int rowL) {
        this.rowL = rowL;
    }

    public void setColL(int colL) {
        this.colL = colL;
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node node, String word, int i) {
        char ch = word.charAt(i);
        if (node == null) {
            node = new Node();
            node.ch = ch;
        }
        if (ch > node.ch) node.right = insert(node.right, word, i);
        else if (ch < node.ch) node.left =  insert(node.left, word, i);
        else if (word.length() - 1 == i) node.isWord = true;
        else node.mid = insert(node.mid, word, i+1);
        return node;
    }

    public void search(char[][] board, int i, int j, Set<String> res) {
        if (rowL == -1 || colL == -1) throw new IllegalArgumentException();
        find(root, board, i, j, new StringBuilder(), res, new boolean[rowL][colL]);
    }

    private void find(Node node, char[][] board, int i, int j, StringBuilder sb, Set<String> res, boolean[][] visited) {
        if (node == null || i < 0 || i >= rowL || j < 0 || j >= colL || visited[i][j]) return;

        char ch = board[i][j];

        if (ch > node.ch) {
            find(node.right, board, i, j, sb, res, visited);
            return;
        } else if (ch < node.ch) {
            find(node.left, board, i, j, sb, res, visited);
            return;
        }
        visited[i][j] = true;

        sb.append(ch);
        if (node.isWord) {
            res.add(sb.toString());
        }

        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                if (dRow == 0 && dCol == 0) continue;
                find(node.mid, board, i+dRow, j+dCol, sb, res, visited);
            }
        }

        visited[i][j] = false;
        sb.deleteCharAt(sb.length()-1);
    }
}
