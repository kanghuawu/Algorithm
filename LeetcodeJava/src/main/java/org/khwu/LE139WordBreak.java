package org.khwu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LE139WordBreak {
//	public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] wordBreaks = new boolean[s.length()+1];
//        wordBreaks[0] = true;
//        for (int i=1; i<=s.length(); i++) {
//            for ( int j=0; j<i; j++) {
//                if (wordBreaks[j] && wordDict.contains(s.substring(j, i))) {
//                    wordBreaks[i] = true;
//                }
//            }
//        }
//        
//        return wordBreaks[s.length()];
//    }
	public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> wordBreaks = new LinkedList<Integer>();
        wordBreaks.add(0);
        Set<Integer> visited = new HashSet<Integer>(); // speed improvement; otherwise timeout
        visited.add(0); 
        while (!wordBreaks.isEmpty()) {
            int idx = wordBreaks.remove();
            for (int i=idx+1; i<=s.length(); i++) {
                if (visited.contains(i)) continue;
                if (wordDict.contains(s.substring(idx, i))) {
                    if (i == s.length()) return true;
                    wordBreaks.add(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }
}
