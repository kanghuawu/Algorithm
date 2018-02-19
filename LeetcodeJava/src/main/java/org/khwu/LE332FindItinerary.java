package org.khwu;

import java.util.*;

public class LE332FindItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            PriorityQueue<String> pq = graph.get(from);
            if (pq == null) {
                pq = new PriorityQueue<>();
                graph.put(from, pq);
            }
            pq.add(to);
        }

        LinkedList<String> path = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String from = stack.pop();
            while (graph.containsKey(from) && !graph.get(from).isEmpty()) {
                String to = graph.get(from).poll();
                stack.push(from);
                from = to;
            }
            path.addFirst(from);
        }
        return path;
    }

//    public List<String> findItinerary(String[][] tickets) {
//
//        boolean[] marked = new boolean[tickets.length];
//        Map<String, List<Integer>> map = new HashMap<>();
//
//        for (int i = 0; i < tickets.length; i++) {
//            String airport = tickets[i][0];
//            List<Integer> li = map.get(airport);
//            if (li == null) {
//                li = new ArrayList<>();
//            }
//            li.add(i);
//            map.put(airport, li);
//        }
//        // System.out.println(map);
//
//        List<List<String>> res = new ArrayList<>();
//        for (int i : map.get("JFK")) {
//            if (!marked[i]) {
//                Stack<String> dq = new Stack<>();
//                dfs(marked, i, new Stack<String>(), res, map, tickets);
//            }
//        }
//        // System.out.println(res);
//
//        Collections.sort(res, new Comparator<List<String>>() {
//            @Override
//            public int compare(List<String> a, List<String> b) {
//                for (int i = 1; i < a.size(); i++) {
//                    int comp = a.get(i).compareTo(b.get(i));
//                    if (comp != 0) {
//                        return comp;
//                    }
//                }
//                return 0;
//            }
//        });
//
//        return res.get(0);
//    }
//
//    private void dfs(boolean[] marked, int ticket, Stack<String> stack, List<List<String>> res, Map<String, List<Integer>> map, String[][] tickets) {
//
//        marked[ticket] = true;
//        String from = tickets[ticket][0];
//        String to = tickets[ticket][1];
//        stack.add(from);
//
//        // System.out.println(ticket);
//        // System.out.println(stack);
//
//        if (stack.size() == tickets.length) {
//            stack.add(to);
//            res.add(new ArrayList<String>(stack));
//            stack.pop();
//            stack.pop();
//            marked[ticket] = false;
//            return;
//        }
//
//
//        if (map.containsKey(to)) {
//            for (int nxt : map.get(to)) {
//                if (!marked[nxt]) {
//                    dfs(marked, nxt, stack, res, map, tickets);
//                }
//            }
//        }
//
//        stack.pop();
//        marked[ticket] = false;
//    }
}
