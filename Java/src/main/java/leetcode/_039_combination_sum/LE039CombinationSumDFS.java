package leetcode._039_combination_sum;

import java.util.ArrayList;
import java.util.List;

public class LE039CombinationSumDFS {
    // MY 2017-1-8
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            li.add(candidates[i]);
            dfs(i, candidates, res, li, target - candidates[i]);
            li.remove(li.size() - 1);
        }
    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList();
//        List<Integer> list = new ArrayList();
//        helper(candidates, 0, target, list, res);
//        return res;
//    }
//
//    public void helper(int[] candidates, int idx, int remain, List<Integer> list, List<List<Integer>> res) {
//        if (remain < 0) return;
//        if (remain == 0) res.add(new ArrayList(list));
//        for (int i = 0; i < candidates.length; i ++) {
//            if (i < idx) continue;
//            list.add(candidates[i]);
//            helper(candidates, i, remain - candidates[i], list, res);
//            list.remove(list.size() - 1);
//        }
//    }
}
