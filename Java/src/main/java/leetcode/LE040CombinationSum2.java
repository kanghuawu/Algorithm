package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LE040CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int[] candidates, int idx, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i - 1] == candidates[i] ) {
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
