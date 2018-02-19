package org.khwu._266_palindrome_permutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LE266CanPermutePalindrome {
    // MY
    public boolean canPermutePalindrome(String s) {
        int[] store = new int[128];
        for (char ch : s.toCharArray()) {

            store[ch]++;
        }
        int pal = 0;
        for (int j = 0; j < 128; j++) {
            pal += (store[j] % 2);
        }
        return pal == 0 || pal == 1;
    }

    // ref: https://leetcode.com/problems/palindrome-permutation/discuss/69582
//    public boolean canPermutePalindrome(String s) {
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!set.add(s.charAt(i))) {
//                set.remove(s.charAt(i));
//            }
//        }
//        return set.size() == 0 || set.size() == 1;
//    }

    // MY java 8
//    public boolean canPermutePalindrome(String s) {
//        Map<String, Long> map = Arrays.stream(s.split("")).
//                collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//        int pal = 0;
//        for (long val : map.values()) {
//            pal += (val % 2);
//        }
//        return pal == 0 || pal == 1;
//    }
//
//    public static void main(String[] args) {
//
//    }
}
