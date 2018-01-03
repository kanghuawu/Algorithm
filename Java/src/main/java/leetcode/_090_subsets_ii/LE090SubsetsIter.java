package leetcode._090_subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LE090SubsetsIter {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = (i > 0 && nums[i] == nums[i-1]) ? size : 0;
            size = res.size();
            for (int j = start; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
