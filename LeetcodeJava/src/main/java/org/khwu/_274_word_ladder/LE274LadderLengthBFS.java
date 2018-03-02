package org.khwu._274_word_ladder;

import java.util.*;

public class LE274LadderLengthBFS {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<String> level = new HashSet<>();
        level.add(beginWord);
        visited.add(beginWord);
        int depth = 1;
        while (!level.isEmpty()) {
            Set<String> nxtLevel = new HashSet<>();
            for (String s : level) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    for (int ch = 'a'; ch <= 'z'; ch++) {
                        if (((char) ch) == tmp) continue;
                        arr[i] = ((char) ch);
                        String nStr = new String(arr);
                        if (dic.contains(nStr) && visited.add(nStr)) {
                            if (endWord.equals(nStr)) return depth+1;
                            nxtLevel.add(nStr);
                        }
                    }
                    arr[i] = tmp;
                }
            }
            depth++;
            level = nxtLevel;
        }
        return 0;
    }
}
