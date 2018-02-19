package org.khwu._060_permutation_sequence;

import java.util.LinkedList;
import java.util.List;

public class LE060GetPermutation {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        List<String> li = new LinkedList<>();
        for (int i = 0; i < fact.length; i++) {
            if (i > 0) fact[i] = fact[i-1] * i;
            li.add(String.valueOf(i+1));
        }
        // System.out.println(Arrays.toString(fact));
        // System.out.println(li);
        StringBuilder sb = new StringBuilder(n);
        dfs(sb, fact, li, n - 1, k);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, int[] fact, List<String> li, int n, int k) {
        if (n == -1) {
            return;
        }
        int sum = 0;
        // System.out.println(li);
        for (int i = 0; i < li.size(); i++) {
            sum += fact[n];
            if (sum >= k) {
                sb.append(li.remove(i));
                dfs(sb, fact, li, n-1, k - (sum - fact[n]));
                break;
            }
        }
    }
}
