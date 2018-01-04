package leetcode._046_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LE046PermuteIter {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<Integer>(){{
            add(nums[0]);
        }});
        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = res.remove(0);
                for (int k = 0; k <= i; k++) {
                    List<Integer> per = new LinkedList<>(tmp);
                    per.add(k, nums[i]);
                    res.add(per);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        LE046PermuteIter t = new LE046PermuteIter();
        System.out.println(t.permute(a));
    }
}
