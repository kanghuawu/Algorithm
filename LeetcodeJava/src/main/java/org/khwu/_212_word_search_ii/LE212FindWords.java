package org.khwu._212_word_search_ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LE212FindWords {
    private int rowL;
    private int colL;
    public List<String> findWords(char[][] board, String[] words) {
        rowL = board.length;
        if (rowL == 0) return new ArrayList<>();
        colL = board[0].length;
        Trie trie = new Trie();

        for (String s : words) {
            trie.insert(s);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                trie.search(board, i, j, res);
            }
        }
        // System.out.println(res.size());
        return new ArrayList<>(res);
    }

    class Trie {
        private Node root;

        class Node {
            private char ch;
            private Node left, mid, right;
            private boolean isWord;
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
            find(node.mid, board, i-1, j, sb, res, visited);
            find(node.mid, board, i+1, j, sb, res, visited);
            find(node.mid, board, i, j-1, sb, res, visited);
            find(node.mid, board, i, j+1, sb, res, visited);

            visited[i][j] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
