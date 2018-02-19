package p25_burrows;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;


import java.util.Deque;
import java.util.LinkedList;


/*
Useful youtube videos for understanding Burrows Wheeler transformation.
https://www.youtube.com/watch?v=4n7NPk5lwbI
https://www.youtube.com/watch?v=biFtVGrDJ4U
 */
public class BurrowsWheeler {
    private static final int R = 256;
    // apply Burrows-Wheeler transform, reading from standard input and writing to standard output
    public static void transform() {
        String text = BinaryStdIn.readString();
        CircularSuffixArray suffix = new CircularSuffixArray(text);
        int len = suffix.length();
        for (int i = 0; i < len; i++) {
            if (suffix.index(i) == 0) {
                BinaryStdOut.write(i);
                break;
            }
        }
        for (int i = 0; i < len; i++) {
            int pos = suffix.index(i);
            pos = (pos + len - 1) % len;
            BinaryStdOut.write(text.charAt(pos));
        }
        BinaryStdOut.close();
    }
    // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        char[] t = BinaryStdIn.readString().toCharArray();
        int len = t.length;

        Deque<Integer>[] order = new Deque[R];

        for (int i = 0; i < len; i++) {
            if (order[t[i]] == null) {
                order[t[i]] = new LinkedList<>();
            }
            order[t[i]].addLast(i);
        }

        int[] next = new int[len];
        for (int i = 0, j = 0; i < R; i++) {
            if (order[(char) i] != null) {
                Deque<Integer> tmp = order[(char) i];
                while (tmp.size() > 0) {
                    next[j++] = tmp.removeFirst();
                }
            }
        }

        for (int i = next[first], j = 0; j < len; i = next[i], j++) {
            BinaryStdOut.write(t[i]);
        }

        BinaryStdOut.close();
    }
    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("-")) transform();
        else if (args.length == 1 && args[0].equals("+")) inverseTransform();
        else throw new IllegalArgumentException();
    }
}
