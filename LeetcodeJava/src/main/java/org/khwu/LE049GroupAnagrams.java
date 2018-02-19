package org.khwu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LE049GroupAnagrams {
    // MY
    // ref: https://leetcode.com/problems/group-anagrams/solution/
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] charr = s.toCharArray();
            Arrays.sort(charr);
            String sorted = String.valueOf(charr);
            List<String> list = map.get(sorted);
            if (list == null) {
                list = new ArrayList();
                map.put(sorted, list);
            }
            list.add(s);
        }

        return new ArrayList(map.values());
    }

    // ref: https://leetcode.com/problems/group-anagrams/solution/
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
//        for (String s : strs) {
//            char[] charr = s.toCharArray();
//            Arrays.sort(charr);
//
//            int[] alphabet = new int[26];
//
//            for (char c : charr) {
//                alphabet[c - 'a']++;
//            }
//
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i< alphabet.length; i++) {
//                sb.append(String.valueOf(alphabet[i]));
//                sb.append("#");
//            }
//            String hash = sb.toString();
//            List<String> list = map.get(hash);
//            if (list == null) {
//                list = new ArrayList();
//                map.put(hash, list);
//            }
//            list.add(s);
//        }
//
//        return new ArrayList(map.values());
//    }
}
