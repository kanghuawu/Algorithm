package p25_burrows;


import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    private static final int R = 256;
    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        char[] seq = createSeq();
        String s = BinaryStdIn.readString();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            for (int j = 0; j < R; j++) {
                if (seq[j] == ch) {
                    System.arraycopy(seq, 0, seq, 1, j);
                    seq[0] = ch;
                    BinaryStdOut.write((char) j);
                    break;
                }
            }
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        char[] seq = createSeq();

        String s = BinaryStdIn.readString();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i);
            char ch = seq[idx];
            System.arraycopy(seq, 0, seq, 1, idx);
            seq[0] = ch;
            BinaryStdOut.write(ch);
        }
        BinaryStdOut.close();
    }

    private static char[] createSeq() {
        char[] seq = new char[R];

        for (int i = 0; i < R; i++) {
            seq[i] = (char) i;
        }
        return  seq;
    }
    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("-")) encode();
        else if (args.length == 1 && args[0].equals("+")) decode();
        else throw new IllegalArgumentException();
    }
}
