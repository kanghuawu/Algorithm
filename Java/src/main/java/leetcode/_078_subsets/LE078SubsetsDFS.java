package leetcode._078_subsets;

import java.util.ArrayList;
import java.util.List;

public class LE078SubsetsDFS {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int curr, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        // System.out.println(res);
        for (int i = curr; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i+1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
