package leetcode;

public class LE161IsOneEditDistance {
//    public boolean isOneEditDistance(String s, String t) {
//        if(s.length() < t.length()) return isOneEditDistance(t, s);
//        if(s.length() - t.length() > 1 || s.equals(t)) return false;
//        int i = 0;
//        int j = 0;
//        int count = 0;
//        while(i < s.length() && j < t.length()){
//            if(s.charAt(i) != t.charAt(j)) count++;
//            if(count > 1) return false;
//            if(s.length() != t.length()){
//                i += 2;
//            }else{
//                i++;
//                j++;
//            }
//
//        }
//        return true;
//    }
//    public boolean isOneEditDistance(String s, String t) {
//    	if(Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
//    	int i = 0;
//    	int j = 0;
//    	int re = 0;
//    	while(i != s.length() && j != t.length()){
//    		if(i < s.length()) {
//    			re ^= s.charAt(i);
//    			i++;
//    		}
//    		if(j < t.length()) {
//    			re ^= t.charAt(j);
//    			j++;
//    		}
//    	}
//    	return (re >= 65 && re <= 90) || (re >= 97 && re <= 122);
//    }
//    public boolean isOneEditDistance(String s, String t) {
//    	if(Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
//    	else if(s.length() < t.length()) return isOneEditDistance(t, s);
//    	int count = 0;
//    	for(int i = 0; i < Math.min(s.length(), t.length());i++ ){
//    	    if(s.length() == t.length() && s.charAt(i) != t.charAt(i)){
//    	        count++;
//    	    }else if(s.length() != t.length()){
//    	        if(s.charAt(i) != t.charAt(i) && s.charAt(i + 1) != t.charAt(i)) return false;
//    	        if(s.charAt(i) != t.charAt(i) && count == 0) count++;
//    	        else if(s.charAt(i + 1) != t.charAt(i) && count > 0) count++;
//    	    }
//    	}
//    	System.out.println(count);
//    	return count <= 1;
//    }
	
//	public boolean isOneEditDistance(String s, String t) {
//	    for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
//	    	if (s.charAt(i) != t.charAt(i)) {
//	    		if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
//	    			return s.substring(i + 1).equals(t.substring(i + 1));
//				else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
//					return s.substring(i).equals(t.substring(i + 1));
//				else // s is longer than t, so the only possibility is deleting one char from s
//					return t.substring(i).equals(s.substring(i + 1));
//	    	}
//	    }
//	    //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
//	    return Math.abs(s.length() - t.length()) == 1;
//	}
//	public boolean isOneEditDistance(String s, String t) {
//	    int m = s.length(), n = t.length();
//	    if (Math.abs(m - n) > 1) return false;
//	    int k = Math.min(m, n);
//	    int i = 0, j = 0;
//	    while (i < k && s.charAt(i) == t.charAt(i)) ++i;
//	    while (j < k - i && s.charAt(m - 1 - j) == t.charAt(n - 1 - j)) ++j;
//	    return m + n - k - 1 == i + j;
//	}

	public boolean isOneEditDistance(String s, String t) {
	    
	    int s1 = -1, s2 = s.length(), t1 = -1, t2 = t.length();
	    char[] sArr = s.toCharArray(), tArr = t.toCharArray();
	    
	    if (Math.abs(s2 - t2) > 1) {
	        return false;
	    }

	    while (s1 < s2 - 1 && t1 < t2 - 1 && sArr[s1 + 1] == tArr[t1 + 1]) {
	        s1++;
	        t1++;
	    }

	    // equals
	    if (s2 == t2 && s1 == s2 - 1) {
	        return false;
	    }

	    while (s2 > 0 && t2 > 0 && sArr[s2 - 1] == tArr[t2 - 1]) {
	        s2--;
	        t2--;
	    }

	    return Math.max(s2 - s1, t2 - t1) < 3;
	}
}
