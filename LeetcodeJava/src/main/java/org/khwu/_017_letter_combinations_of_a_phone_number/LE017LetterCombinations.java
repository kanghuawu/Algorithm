package org.khwu._017_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

public class LE017LetterCombinations {
    private final String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            return result;
        }
        letterCombinationsHelper("", 0, result, digits);
        return result;
    }
    
    private void letterCombinationsHelper(String subset, int idx, List<String> result, String digits) {
        if (idx >= digits.length()) {
            result.add(subset);
            return;
        }
        String letters = dict[digits.charAt(idx) - '2'];
        for (int i=0; i<letters.length(); i++) {
            letterCombinationsHelper(subset+letters.charAt(i), idx+1, result, digits);
        }
    }
}
