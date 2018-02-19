package org.khwu._784_letter_case_permutation;

import java.util.ArrayList;
import java.util.List;

public class LE784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S, new StringBuilder(), res, 0);
        return res;
    }

    private void dfs(String s, StringBuilder sb, List<String> res, int idx) {
        if (idx == s.length()) {
            res.add(sb.toString());
            return;
        }
        if (s.charAt(idx) > 57) {
            if (s.charAt(idx) >= 97) {
                dfs(s, sb.append((char) (s.charAt(idx) - 32)), res, idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                dfs(s, sb.append((char) (s.charAt(idx) + 32)), res, idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        dfs(s, sb.append((char) (s.charAt(idx))), res, idx + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
