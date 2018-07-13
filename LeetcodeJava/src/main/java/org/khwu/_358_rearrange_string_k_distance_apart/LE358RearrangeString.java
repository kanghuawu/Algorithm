package org.khwu._358_rearrange_string_k_distance_apart;

import java.util.*;

public class LE358RearrangeString {

    public String rearrangeString(String s, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> -(a.count - b.count));
        Map<Character, Pair> counts = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            Pair p = counts.getOrDefault(ch, new Pair(ch, 0));
            p.count++;
            counts.put(ch, p);
        }

        for (char ch : counts.keySet()) {
            pq.add(counts.get(ch));
        }

        Deque<Pair> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair nxt = pq.poll();
            sb.append(nxt.ch);
            nxt.count--;
            dq.addLast(nxt);
            if (dq.size() >= k) {
                Pair tmp = dq.removeFirst();
                if (tmp.count > 0) {
                    pq.add(tmp);
                }
            }
        }

        return sb.length() == n ? sb.toString() : "";
    }

    private static class Pair {
        private char ch;
        private int count;
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public boolean equals(Object obj) {
            Pair that = (Pair) obj;
            return this.ch == that.ch;
        }

        public int hashCode() {
            return Objects.hash(ch);
        }
    }
}
