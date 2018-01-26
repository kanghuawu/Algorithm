package p24_boggle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class BoggleSolver
{
    private Trie trie;
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        trie = new Trie();
        for (String s : dictionary) {
            if (s.contains("QU")) s = s.replaceAll("QU", "Q");
            else if (s.contains("Q")) continue;
            trie.insert(s);
        }
    }


    private class Trie {
        Node root;
        int rowL = -1;
        int colL = -1;
        class Node {
            char ch;
            boolean isWord;
            Node left, mid, right;
        }
        Trie() {}

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

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        int rowL = board.rows();
        int colL = board.cols();
        char[][] boardChar = new char[rowL][colL];
        trie.rowL = rowL;
        trie.colL = colL;
        for (int row = 0; row < rowL; row++) {
            for (int col = 0; col < colL; col++) {
                boardChar[row][col] = board.getLetter(row, col);
            }
        }
        Set<String> res = new HashSet<>();
        for (int row = 0; row < rowL; row++) {
            for (int col = 0; col < colL; col++) {
                trie.search(boardChar, row, col, res);
            }
        }
        for (String s : res) {
            if (s.contains("Q")) {
                res.add(s.replaceAll("Q", "QU"));
                res.remove(s);
            }
        }
        return res;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        int len = word.length();
        if (len <=2 ) return 0;
        else if (len <= 4) return 1;
        else if (len == 5) return 2;
        else if (len == 6) return 3;
        else if (len == 7) return 5;
        return 11;
    }

    public static void main(String[] args) {
        String path1 = "/Users/khwu/Projects/Algorithm/AlgorithmsCoursera/src/main/java/p24_boggle/test/dictionary-yawl.txt";
        String path2 = "/Users/khwu/Projects/Algorithm/AlgorithmsCoursera/src/main/java/p24_boggle/test/board-points26539.txt";
        In in = new In(path1);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(path2);
        int score = 0;
        for (String word : solver.getAllValidWords(board)) {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }
}
