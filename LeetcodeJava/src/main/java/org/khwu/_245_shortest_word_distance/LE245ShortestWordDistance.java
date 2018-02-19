package org.khwu._245_shortest_word_distance;

public class LE245ShortestWordDistance {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int first = -1;
        int second = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                first = i;
            }
            if (first != -1 && second != -1 && first != second) {
                min = Math.min(Math.abs(first - second), min);
            }
            if (words[i].equals(word2)) {
                second = i;
            }
        }
        if (first != -1 && second != -1 && first != second) {
            min = Math.min(Math.abs(first - second), min);
        }
        return min;
    }
}
