package leetcode._047_permutations_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LE047PermuteUniqueDFSMap {
    private int len;
    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int n = map.getOrDefault(num, 0);
            map.put(num, n + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(map, new ArrayList<>(), res);
        return res;
    }

    private void dfs(Map<Integer, Integer> map, List<Integer> per, List<List<Integer>> res) {
        if (per.size() == len) {
            res.add(new ArrayList<>(per));
            return;
        }
        for (int num : map.keySet()) {
            int n = map.get(num);
            if (n > 0) {
                map.put(num, n - 1);
                per.add(num);
                dfs(map, per, res);
                per.remove(per.size() - 1);
                map.put(num, n);
            }
        }
    }
}
