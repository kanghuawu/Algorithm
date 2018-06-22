package org.khwu._721_accounts_merge;

import java.util.*;

public class LE721AccountsMergeDFS {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.isEmpty()) return res;
        Map<String, String> name = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String curName = account.get(0);
            Set<String> emails;
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                name.put(email, curName);
                graph.putIfAbsent(email, new HashSet<>());
                if (i == 1) continue;
                graph.get(email).add(account.get(i-1));
                graph.get(account.get(i-1)).add(email);
            }
        }

        Set<String> visited = new HashSet<>();
        List<String> group = new ArrayList<>();
        for (String email : graph.keySet()) {
            group.clear();
            if (!visited.contains(email)) {
                dfs(email, graph, visited, group);
                Collections.sort(group);
                List<String> tmp = new ArrayList<>();
                tmp.add(name.get(email));
                tmp.addAll(group);
                res.add(tmp);
            }
        }
        return res;
    }

    private void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> group) {
        visited.add(email);
        group.add(email);
        for (String nb : graph.get(email)) {
            if (!visited.contains(nb)) dfs(nb, graph, visited, group);
        }
    }
}
