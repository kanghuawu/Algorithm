package org.khwu._804_unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

public class LE804UniqueMorseRepresentations {
}

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) return 0;
        String[] mos = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int n = words.length;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char[] arr = words[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                sb.append(mos[arr[j] - 'a']);
            }
            res.add(sb.toString());
        }
        return res.size();
    }
}