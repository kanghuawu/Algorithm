package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LE047PermuteUnique {
    // ref: https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList();
        helper(nums, used, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> it) {
        if (nums.length == it.size()) {
            res.add(new ArrayList(it));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            it.add(nums[i]);
            helper(nums, used, res, it);
            used[i] = false;
            it.remove(it.size() - 1);
        }
    }
}
