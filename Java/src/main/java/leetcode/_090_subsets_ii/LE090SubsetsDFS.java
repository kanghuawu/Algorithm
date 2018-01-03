package leetcode._090_subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LE090SubsetsDFS {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int curr, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        // System.out.println(res);
        for (int i = curr; i < nums.length; i++) {
            if (i > curr && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i+1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
