package p25_burrows;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SuffixArrayX;

public class CircularSuffixArray {
    private final SuffixArrayX suffix;
    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) throw new IllegalArgumentException();
        suffix = new SuffixArrayX(s);
    }

    // length of s
    public int length() {
        return suffix.length();
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= length()) throw new IllegalArgumentException();
        return suffix.index(i);
    }

    // unit testing (required)
    public static void main(String[] args) {
        String text = "ABRACADABRA!";

        CircularSuffixArray c = new CircularSuffixArray(text);
        StdOut.printf("Index 0 expect 11, actual %d%n", c.index(0));
        StdOut.printf("Index 1 expect 10, actual %d%n", c.index(1));
        StdOut.printf("Index 2 expect 7, actual %d%n", c.index(2));
        StdOut.printf("Index 9 expect 6, actual %d%n", c.index(9));
        StdOut.printf("Index 10 expect 9, actual %d%n", c.index(10));
        StdOut.printf("Index 11 expect 2, actual %d%n", c.index(11));
        StdOut.printf("Text length expect %d, actual %d%n", text.length(), c.length());
    }
}
