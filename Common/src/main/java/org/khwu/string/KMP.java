package org.khwu.string;

import java.util.Arrays;

public class KMP {

    private final int R = 256;
    private final String pat;
    private final int[][] dfa;

    public KMP(String pat) {
        int len = pat.length();
        this.pat = pat;
        this.dfa = new int[R][len];

        dfa[pat.charAt(0)][0] = 1;
        for (int col = 1, pt = 0; col < len; col++) {
            for (int row = 0; col > 0 && row < R; row++) {
                dfa[row][col] = dfa[row][pt];
            }
            dfa[pat.charAt(col)][col] = col+1;
            pt = dfa[pat.charAt(col)][pt];
        }
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        for (int i = 0, j = 0; i < n; i++) {
            j = dfa[txt.charAt(i)][j];
            if (j == m) return i-m+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String pat = "ABABAC";
        String txt = "AABABAC";
        KMP kmp = new KMP(pat);
        System.out.println(kmp.search(txt));
    }
}
