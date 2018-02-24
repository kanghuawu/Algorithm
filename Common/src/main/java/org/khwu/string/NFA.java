package org.khwu.string;

import java.util.Stack;

public class NFA {
    private final int R = 256;
    private final String regex;
    private final int[][] graph;
    private final int m;

    public NFA(String regex) {
        this.regex = regex;
        m = regex.length();
        graph = new int[R][m+1];
        Stack<Integer> ops = new Stack<>();
        for (int i = 0; i < m; i++) {

        }
    }
}
