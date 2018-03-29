package org.khwu._301_remove_invlida_parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LE301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        char[] ar = s.toCharArray();
        int rmL = 0;
        int rmR = 0;
        for (int i = 0; i < n; i++) {
            if (ar[i] == '(') {
                rmL++;
            } else if (ar[i] == ')') {
                if (rmL == 0) {
                    rmR++;
                } else {
                    rmL--;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(ar, 0, new StringBuilder(), res, rmL, rmR, 0);

        return new ArrayList<>(res);
    }

    private void dfs(char[] ar, int i, StringBuilder sb, Set<String> res, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (i == ar.length) {
            if (rmL == 0 && rmR == 0 && open == 0) res.add(sb.toString());
            return;
        }

        char c = ar[i];
        int n = sb.length();

        if (ar[i] == '(') {
            dfs(ar, i + 1, sb, res, rmL - 1, rmR, open);
            dfs(ar, i + 1, sb.append(c), res, rmL, rmR, open + 1);
        } else if (ar[i] == ')') {
            dfs(ar, i + 1, sb, res, rmL, rmR - 1, open);
            dfs(ar, i + 1, sb.append(c), res, rmL, rmR, open - 1);
        } else {
            dfs(ar, i + 1, sb.append(c), res, rmL, rmR, open);
        }

        sb.setLength(n);
    }
}
