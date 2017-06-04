package leetcode;

import java.util.HashMap;
import java.util.Hashtable;

public class LE242isAnagram {
//	public boolean isAnagram(String s, String t) {
//		if(s.length() != t.length()) return false;
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        for(char ch : s.toCharArray()){
//        	if(map.containsKey(ch)){
//        		map.put(ch, map.get(ch) + 1);
//        	}else{
//        		map.put(ch, 1);
//        	}
//        }
//        
//        for(char ch: t.toCharArray()){
//        	if(!map.containsKey(ch) || map.get(ch) == 0){
//        		return false;
//        	}else if(map.get(ch) > 0){
//        		map.put(ch, map.get(ch)-1);
//        	}
//        }
//        return true;
//    }
	
	//
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
        int[] result = new int[26];
		for(int i=0; i < s.length(); i++){
        	result[s.charAt(i)-'a']++;
        	result[t.charAt(i)-'a']--;
        }
		for(int i=0; i<26; i++){
			if(result[i] != 0) return false;
		}
        return true;
    }
	
	public static void main(String[] args){
		String s = "cart";
		String t = "tacr";
		LE242isAnagram ana = new LE242isAnagram();
		System.out.println(ana.isAnagram(s, t));
	}
}
