package org.khwu._792_number_of_matching_subsequences;

public class LE792NumMatchingSubseq {
    public int numMatchingSubseq(String S, String[] words) {
        int n = S.length();
        int[][] nxt = new int[n+1][26];
        for (int i = 0; i < 26; i++) nxt[n][i] = n+1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) nxt[i][j] = nxt[i+1][j];
            nxt[i][S.charAt(i) - 'a'] = i + 1;
        }
        int res = words.length;
        for (String s : words) {
            char[] ar = s.toCharArray();
            int idx = 0;
            for (int i = 0; i < ar.length; i++) {
                idx = nxt[idx][ar[i] - 'a'];
                if (idx > n) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
