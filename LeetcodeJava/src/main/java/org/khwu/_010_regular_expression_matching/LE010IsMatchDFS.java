package org.khwu._010_regular_expression_matching;

public class LE010IsMatchDFS {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (p.length() == j) return s.length() == i;
        if (j+1 < p.length() && p.charAt(j+1) == '*') {
            return isMatch(s, i, p, j+2) || (i < s.length() && ((p.charAt(j) == '.' ||
                    s.charAt(i) == p.charAt(j)) &&
                    isMatch(s, i+1, p, j)));
        }
        if (p.charAt(j) == '.') {
            return isMatch(s, i+1, p, j+1);
        }
        return i < s.length() && s.charAt(i) == p.charAt(j) && isMatch(s, i+1, p, j+1);
    }
}
