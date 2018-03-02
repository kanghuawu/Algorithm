package org.khwu._127_word_ladder;

import java.util.*;

public class LE127LadderLengthGraph {
    // TLE
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int begin = -1;
        int end = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) begin = i;
            if (wordList.get(i).equals(endWord)) end = i;
        }
        if (end == -1) return 0;
        if (begin == -1) {
            wordList.add(beginWord);
            begin = wordList.size() - 1;
        }

        Map<String, Set<String>> dic = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            dic.putIfAbsent(s, new HashSet<>());
            Set<String> set = dic.get(s);
            for (int j = 0; j < s.length(); j++) {
                String tmp = "^" + s.substring(0, j) + "." + s.substring(j+1, s.length()) + "$";
                set.add(tmp);
            }
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String cur = wordList.get(i);
            Set<String> set = dic.get(cur);
            for (int j = i+1; j < wordList.size(); j++) {
                for (String regex : set) {
                    if (wordList.get(j).matches(regex)) {
                        graph.putIfAbsent(i, new HashSet<>());
                        graph.putIfAbsent(j, new HashSet<>());
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                        break;
                    }
                }
            }
        }
        // System.out.println(graph);
        // System.out.println(begin + " " + end);
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(begin);
        int level = 1;
        boolean[] visited = new boolean[wordList.size()];
        visited[begin] = true;
        while (!deque.isEmpty()) {
            Deque<Integer> tmp = new LinkedList<>();
            while (!deque.isEmpty()) {
                int cur = deque.removeFirst();
                for (int nb : graph.getOrDefault(cur, new HashSet<>())) {
                    if (nb == end) return level+1;
                    if (visited[nb]) continue;
                    visited[cur] = true;
                    tmp.addLast(nb);
                }
            }
            deque = tmp;
            level++;
        }
        return 0;
    }
}
