package org.khwu._243_shortest_word_distance;

public class LE243ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int first = -1;
        int second = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                first = i;
            }
            if (words[i].equals(word2)) {
                second = i;
            }
            if (first != -1 && second != -1) {
                min = Math.min(Math.abs(first - second), min);
            }
        }
        return min;
    }
}
