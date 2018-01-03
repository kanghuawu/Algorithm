package leetcode._078_subsets;

import java.util.ArrayList;
import java.util.List;

public class LE078SubsetsIter {
    // ref: https://leetcode.com/problems/subsets/discuss/27279/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i : nums) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(i);
                res.add(tmp);
            }
        }
        return res;
    }
}
