package org.khwu._126_word_ladder_ii;

import java.util.*;

public class LE126FindLadders {
    private int depth = 0;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> fw = new HashSet<>();
        Set<String> bw = new HashSet<>();
        Set<String> dic = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();

        if (!dic.contains(endWord)) return res;

        fw.add(beginWord);
        bw.add(endWord);
        if (!bfs(fw, bw, dic, graph, false)) {
            System.out.println(graph);
            return res;
        }

        List<String> tmp = new ArrayList<>();
        tmp.add(beginWord);
        dfs(res, graph, tmp, beginWord, endWord);
        return res;
    }

    private boolean bfs(Set<String> fw, Set<String> bw, Set<String> dic, Map<String, Set<String>> graph, boolean flip) {
        if (fw.isEmpty() || bw.isEmpty()) return false;
        if (fw.size() > bw.size()) return bfs(bw, fw, dic, graph, !flip);
        Set<String> tmp = new HashSet<>();
        dic.removeAll(fw);
        dic.removeAll(bw);
        boolean done = false;
        for (String s : fw) {
            char[] chAr = s.toCharArray();
            for (int i = 0; i < chAr.length; i++) {
                char old = chAr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chAr[i] = ch;
                    String nxt = new String(chAr);

                    String k = flip ? nxt : s;
                    String v = flip ? s : nxt;
                    if (bw.contains(nxt)) {
                        done = true;
                        graph.putIfAbsent(k, new HashSet<>());
                        graph.get(k).add(v);
                    } else if (dic.contains(nxt)) {
                        tmp.add(nxt);
                        graph.putIfAbsent(k, new HashSet<>());
                        graph.get(k).add(v);
                    }
                }
                chAr[i] = old;
            }
        }
        depth++;
        return done || bfs(bw, tmp, dic, graph, !flip);
    }

    private void dfs(List<List<String>> res, Map<String, Set<String>> graph, List<String> tmp, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (String s : graph.getOrDefault(beginWord, new HashSet<>(0))) {
            tmp.add(s);
            dfs(res, graph, tmp, s, endWord);
            tmp.remove(tmp.size()-1);
        }
    }
}
