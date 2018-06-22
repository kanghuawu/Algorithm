package org.khwu._721_accounts_merge;

import java.util.*;

public class LE721AccountsMergeUF {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.isEmpty()) return res;

        Map<String, Integer> pos = new HashMap<>();

        int n = accounts.size();
        UF uf = new UF(n);

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (pos.containsKey(email)) uf.union(i, pos.get(email));
                else pos.put(email, i);
            }
        }

        Map<Integer, Set<String>> emails = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            Set<String> e = emails.getOrDefault(root, new HashSet<>());
            emails.put(root, e);
            for (int j = 1; j < accounts.get(i).size(); j++)
                e.add(accounts.get(i).get(j));
        }

        for (int key : emails.keySet()) {
            LinkedList<String> tmp = new LinkedList<>();
            tmp.addAll(emails.get(key));
            Collections.sort(tmp);
            tmp.addFirst(accounts.get(key).get(0));
            res.add(tmp);
        }

        return res;
    }

    private static class UF {
        private int count;
        private int[] parent;
        private int[] size;

        public UF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int n) {
            while (n != parent[n]) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        public void union(int m, int n) {
            int mParent = find(m);
            int nParent = find(n);
            if (mParent == nParent) return;

            if (size[mParent] > size[nParent]) {
                parent[nParent] = mParent;
                size[mParent] += size[nParent];
            } else {
                parent[mParent] = nParent;
                size[nParent] += size[mParent];
            }
            count--;
        }

        public boolean connected(int m, int n) {
            return find(m) == find(n);
        }
    }
}
