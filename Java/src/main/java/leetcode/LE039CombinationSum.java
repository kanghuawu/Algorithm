package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LE039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        helper(candidates, 0, target, list, res);
        return res;
    }

    public void helper(int[] candidates, int idx, int remain, List<Integer> list, List<List<Integer>> res) {
        if (remain < 0) return;
        if (remain == 0) res.add(new ArrayList(list));
        for (int i = 0; i < candidates.length; i ++) {
            if (i < idx) continue;
            list.add(candidates[i]);
            helper(candidates, i, remain - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
