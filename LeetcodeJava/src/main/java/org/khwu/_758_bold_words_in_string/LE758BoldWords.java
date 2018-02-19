package org.khwu._758_bold_words_in_string;

public class LE758BoldWords {
    public String boldWords(String[] words, String S) {
        int[] bold = new int[S.length()];
        for (String w : words) {
            int idx = S.indexOf(w);
            while (idx != -1) {
                bold[idx] = Math.max(bold[idx], w.length());
                idx = S.indexOf(w, idx + 1);
            }
        }
        // System.out.println(Arrays.toString(bold));
        StringBuilder sb = new StringBuilder();
        int close = -1;
        for (int i = 0; i < S.length(); i++) {
            int tmp = bold[i];
            if (close == -1 && tmp != 0) {
                close = Math.max(tmp + i, close);
                sb.append("<b>");
            } else if (tmp != 0) {
                close = Math.max(tmp + i, close);
            } else if (i == close) {
                sb.append("</b>");
                close = -1;
            }
            sb.append(S.charAt(i));
            if (i == S.length() -1 && close != -1 ) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
