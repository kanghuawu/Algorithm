package p24_boggle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BoggleSolver
{
    private final Trie trie;
    private final TreeSet<String> dictionary;
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        this.dictionary = new TreeSet<>();
        trie = new Trie();
        for (String s : dictionary) {
            this.dictionary.add(s);
            if (s.contains("QU")) s = s.replaceAll("QU", "Q");
            else if (s.contains("Q")) continue;
            trie.insert(s);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        int rowL = board.rows();
        int colL = board.cols();
        char[][] boardChar = new char[rowL][colL];
        trie.setRowL(rowL);
        trie.setColL(colL);
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
        List<String> resReplacement = new ArrayList<>();
        for (String s : res) {
            if (s.contains("Q") && s.length() >= 2) {
                resReplacement.add(s.replaceAll("Q", "QU"));
            } else if (s.length() >= 3) {
                resReplacement.add(s);
            }
        }
        return resReplacement;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (!dictionary.contains(word)) return 0;
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
        String path2 = "/Users/khwu/Projects/Algorithm/AlgorithmsCoursera/src/main/java/p24_boggle/test/board-points777.txt";
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
