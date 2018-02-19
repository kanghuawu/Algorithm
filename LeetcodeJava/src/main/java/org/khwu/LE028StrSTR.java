package org.khwu;

public class LE028StrSTR {
	public int strStr(String haystack, String needle) {
		if(needle.length() == 0) return 0;
		if(haystack.length() < needle.length()) return -1;
        for(int i=0; i<haystack.length(); i++ ){
        	int k=0;
        	for(int j=i; j<haystack.length(); j++){
        		if(k==0 & j+needle.length()>haystack.length()) break;
        		if(haystack.charAt(j)!=needle.charAt(k)) break;
        		k++;
        		if(k==needle.length()) return i;
        	}
        }
        return -1;
    }
	
	//nefel
//	public int strStr(String haystack, String needle) {
//        if(haystack == null || needle == null) return 0;
//        if(needle.length() == 0) return 0;
//        for(int i=0; i<haystack.length(); i++){
//        	if(haystack.charAt(i) == needle.charAt(0)) {
//        		if(substringMatches(haystack, i, needle)){
//        			return i;
//        		}
//        	}
//        }
//        return -1;
//    }
//
//	private boolean substringMatches(final String haystack, final int startIndex, final String needle) {
//		for(int i=startIndex, j=0; i<haystack.length() && j<needle.length(); i++, j++){
//			if(haystack.charAt(i) != needle.charAt(j)) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	//
//	public static int strStr(String haystack, String needle) {
//		return haystack.indexOf(needle);
//	}
	
	
	public static void main(String arg[]){
		String haystack = "aaaabc";
		String needle = "aaab";
		LE028StrSTR ss = new LE028StrSTR();
		System.out.println(ss.strStr(haystack, needle));
//		System.out.println("a"=="a");
	}
}
