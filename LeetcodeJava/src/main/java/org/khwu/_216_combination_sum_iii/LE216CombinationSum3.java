package org.khwu._216_combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

public class LE216CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, k, n);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> li, int curr, int k, int n) {
        if (n < 0 || k < 0) return;
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(li));
            return;
        }
        for (int i = curr; i <= 9; i++) {
            li.add(i);
            dfs(res, li, i + 1, k - 1, n - i);
            li.remove(li.size() - 1);
        }
    }
}
