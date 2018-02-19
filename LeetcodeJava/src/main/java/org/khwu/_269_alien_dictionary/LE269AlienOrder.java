package org.khwu._269_alien_dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LE269AlienOrder {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Set<Character> allChar = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                String str1 = words[i-1];
                String str2 = words[i];
                for (int j = 0; j < Math.min(str1.length(), str2.length()); j++) {
                    if (str1.charAt(j) != str2.charAt(j)) {
                        Set<Character> from = graph.computeIfAbsent(str1.charAt(j), (k) -> new HashSet<>());
                        from.add(str2.charAt(j));
                        break;
                    }

                }
            }
            for (int k = 0; k < words[i].length(); k++) {
                allChar.add(words[i].charAt(k));
            }
        }
        // System.out.println(graph);
        StringBuilder sb = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        Set<Character> onStack = new HashSet<>();
        for (char ch : allChar) {
            if (visited.contains(ch)) continue;
            if (hasCycle(ch, sb, visited, onStack, graph)) return "";
        }
        // System.out.println("a");
        return sb.reverse().toString();
    }

    private boolean hasCycle(char curr, StringBuilder sb, Set<Character> visited, Set<Character> onStack, Map<Character, Set<Character>> graph) {
        visited.add(curr);
        onStack.add(curr);
        Set<Character> li = graph.get(curr);
        if (li != null) {
            for (char nb : li) {
                // System.out.println(nb);
                if (onStack.contains(nb)) return true;
                if (visited.contains(nb)) continue;
                if (hasCycle(nb, sb, visited, onStack, graph)) return true;
            }
        }
        sb.append(curr);
        onStack.remove(curr);
        return false;
    }
}
