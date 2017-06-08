package leetcode;

import java.util.HashMap;

public class LE003LengthOfLongestSubstring{
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
}