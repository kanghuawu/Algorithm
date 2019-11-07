package org.khwu.other;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {

    public static boolean isMatching(String pat, String word) {
        return isMatching(pat, 0, word, 0, new HashMap<>());
    }

    private static boolean isMatching(String pat, int idx1, String word, int idx2, Map<Character, String> dic) {
        if (pat.length() == idx1 && word.length() == idx2) return true;
        if (pat.length() == idx1 || word.length() == idx2) return false;
        char ch = pat.charAt(idx1);
        if (dic.containsKey(ch)) {
            int len = dic.get(ch).length();
            if (idx2 + len > word.length()) return false;
            return dic.get(ch).equals(word.substring(idx2, idx2 + len))
                    && isMatching(pat, idx1 + 1, word, idx2 + len, dic);
        }
        for (int i = idx2; i < word.length(); i++) {
            String s = word.substring(idx2, i + 1);
            dic.put(ch, s);
            if (isMatching(pat, idx1 + 1, word, i + 1, dic)) {
                return true;
            }
            dic.remove(ch);
        }
        return false;
    }

    public static void main(String[] args) {
        String pat = "aabb";
        String word = "xyzabcxzyabc";
        System.out.println(isMatching(pat, word));
    }
}
