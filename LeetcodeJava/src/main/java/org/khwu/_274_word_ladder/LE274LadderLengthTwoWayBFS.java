package org.khwu._274_word_ladder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LE274LadderLengthTwoWayBFS {
    private int depth = 1;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> fw = new HashSet<>();
        Set<String> bw = new HashSet<>();
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        fw.add(beginWord);
        bw.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        if (bfs(fw, bw, dic, visited)) return depth+1;

        return 0;
    }

    private boolean bfs(Set<String> fw, Set<String> bw, Set<String> dic, Set<String> visited) {
        if (fw.isEmpty() || bw.isEmpty()) return false;
        if (fw.size() > bw.size()) return bfs(bw, fw, dic, visited);
        Set<String> tmp = new HashSet<>();
        for (String s : fw) {
            char[] chAr = s.toCharArray();
            for (int i = 0; i < chAr.length; i++) {
                char old = chAr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chAr[i] = ch;
                    String nxt = new String(chAr);
                    if (bw.contains(nxt)) return true;
                    if (dic.contains(nxt) && visited.add(nxt)) {
                        tmp.add(nxt);
                    }
                }
                chAr[i] = old;
            }
        }
        depth++;
        return bfs(bw, tmp, dic, visited);
    }
}
