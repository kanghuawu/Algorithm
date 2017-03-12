package leetcode;

import java.util.HashMap;
import java.util.Vector;

public class LE290wordPattern {
private Object previousValue;

//	public boolean wordPattern(String pattern, String str) {
//		String[] arr = str.split(" ");
////		System.out.println(arr[1]);
//		if(pattern.length() != arr.length) return false;
//		HashMap<Character, Integer> findpattern = new HashMap();
//		HashMap<String, Integer> findstr = new HashMap();
//		for(int i = 0; i < arr.length; i++){
//			if(!findpattern.containsKey(pattern.charAt(i))) findpattern.put(pattern.charAt(i), i);
//			if(!findstr.containsKey(arr[i])) findstr.put(arr[i], i);
//			if(!findpattern.get(pattern.charAt(i)).equals(findstr.get(arr[i]))) {
////				System.out.println(findpattern.get(pattern.charAt(i)) + ", " + findstr.get(arr[i]));
////				System.out.println(pattern.charAt(i) + ", " + arr[i]);
//				return false;
//			}
//		}
//		return true;
//    }
	
	public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        HashMap index = new HashMap();
		for (int i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)){
                return false;
            }
        return true;
    }
	
	public static void main(String arg[]){
		LE290wordPattern test = new LE290wordPattern();
		String pattern = "abba";
		String str = "dog cat cat fish";
		System.out.println(test.wordPattern(pattern, str));
	}
}


