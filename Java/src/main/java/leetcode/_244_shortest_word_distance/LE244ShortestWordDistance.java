package leetcode._244_shortest_word_distance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LE244ShortestWordDistance {
    class WordDistance {

        private Map<String, List<Integer>> map = new HashMap<>();
        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                List<Integer> li = map.get(word);
                if (li == null) {
                    li = new ArrayList<>();
                    map.put(word, li);
                }
                li.add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> li1 = map.get(word1);
            List<Integer> li2 = map.get(word2);
            int min = Integer.MAX_VALUE;
            int i = 0;
            int j = 0;
            while (i < li1.size() && j < li2.size()) {
                int first = li1.get(i);
                int second = li2.get(j);
                min = Math.min(Math.abs(first - second), min);
                if (first > second) {
                    j++;
                } else {
                    i++;
                }
            }
            return min;
        }
    }
}
