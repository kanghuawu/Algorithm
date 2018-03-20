package org.khwu._003_longest_substring_without_repeating_characters;

import java.util.HashMap;

public class LE003LengthOfLongestSubstring{
    //MY
     public int lengthOfLongestSubstring(String s) {
     	if(s.length() < 1) return 0;
         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
         int i = 0;
         int j = 0;
         int max = 0;
         while(j != s.length()){
         	Integer idx = map.put(s.charAt(j), j);
         	if(idx == null || idx < i){
         		if(j - i + 1 > max) max=j - i + 1;
         		j++;
         	}else{
         		i = 1 + idx;
         		j++;
         	}
         }
         return max;
     }

    //Leetcode edtorial solution
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        int[] index = new int[128]; // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            i = Math.max(index[s.charAt(j)], i);
//            ans = Math.max(ans, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//        return ans;
//    }
}