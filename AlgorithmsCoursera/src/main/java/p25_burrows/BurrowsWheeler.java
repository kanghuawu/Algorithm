package p25_burrows;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import java.util.*;

/*
Useful youtube videos for understanding Burrows Wheeler transformation.
https://www.youtube.com/watch?v=4n7NPk5lwbI
https://www.youtube.com/watch?v=biFtVGrDJ4U
 */
public class BurrowsWheeler {
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

        Map<Character, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(t[i], k -> new LinkedList<>()).addLast(i);
        }

        Arrays.sort(t);
        int[] next = new int[len];
        for (int i = 0; i < len; i++) {
            next[i] = map.get(t[i]).removeFirst();
        }

        int cur = first;
        for (int i = 0; i < len; i++) {
            BinaryStdOut.write(t[cur]);
            cur = next[cur];
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
