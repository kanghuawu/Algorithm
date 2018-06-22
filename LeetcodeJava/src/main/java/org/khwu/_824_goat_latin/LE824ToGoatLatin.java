package org.khwu._824_goat_latin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LE824ToGoatLatin {
    public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder ma = new StringBuilder("ma");
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            int start = 1;
            if (vowel.contains(s.charAt(0))) start = 0;
            int n = s.length();
            for (int j = start, count = 0; count < n; count++, j++) {
                sb.append(s.charAt(j % n));
            }
            ma.append('a');
            sb.append(ma);
            if (i != arr.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
