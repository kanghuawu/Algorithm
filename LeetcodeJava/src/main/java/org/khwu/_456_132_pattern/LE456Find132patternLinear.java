package org.khwu._456_132_pattern;

import java.util.Deque;
import java.util.LinkedList;

public class LE456Find132patternLinear {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        Deque<Pair> st =  new LinkedList<>();

        for (int n : nums) {
            if (st.isEmpty() || n < st.getLast().min) {
                st.addLast(new Pair(n, n));
            } else if (st.getLast().max > n && st.getLast().min < n) return true;
            else if (st.getLast().min < n) {
                Pair p = st.removeLast();
                p.max = n;

                while (!st.isEmpty() && st.getLast().max <= p.max) st.removeLast();

                if (!st.isEmpty() && st.getLast().min < n && st.getLast().max > n) return true;
                st.addLast(p);
            }
        }
        return false;
    }

    private static class Pair {
        private int max;
        private int min;
        public Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
}
