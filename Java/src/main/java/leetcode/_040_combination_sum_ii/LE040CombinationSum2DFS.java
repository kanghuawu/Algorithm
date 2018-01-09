package leetcode._040_combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LE040CombinationSum2DFS {
    // MY 2017-1-8
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, res, new ArrayList<>(), target);
        return res;
    }

    private void dfs(int curr, int[] candidates, List<List<Integer>> res, List<Integer> li, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(li));
            return;
        }

        for (int i = curr; i < candidates.length; i++) {
            if (i > curr && candidates[i] == candidates[i-1]) continue;
            li.add(candidates[i]);
            dfs(i + 1, candidates, res, li, target - candidates[i]);
            li.remove(li.size() - 1);
        }
    }

//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList();
//        Arrays.sort(candidates);
//        helper(candidates, 0, target, new ArrayList<Integer>(), res);
//        return res;
//    }
//
//    private void helper(int[] candidates, int idx, int target, List<Integer> list, List<List<Integer>> res) {
//        if (target == 0) {
//            res.add(new ArrayList(list));
//            return;
//        }
//        if (target < 0) {
//            return;
//        }
//        for (int i = idx; i < candidates.length; i++) {
//            if (i > idx && candidates[i - 1] == candidates[i] ) {
//                continue;
//            }
//            list.add(candidates[i]);
//            helper(candidates, i + 1, target - candidates[i], list, res);
//            list.remove(list.size() - 1);
//        }
//    }
}
