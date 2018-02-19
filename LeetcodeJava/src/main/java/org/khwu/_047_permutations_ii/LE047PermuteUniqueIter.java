package org.khwu._047_permutations_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LE047PermuteUniqueIter {
    // MY 2017-1-4 ref: https://leetcode.com/problems/permutations-ii/discuss/18630
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>(){{
            add(new LinkedList<>());
        }};

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> li = res.remove(0);
                for (int j = 0; j <= li.size(); j++) {
                    if (j > 0 && li.get(j-1) == num) {
                        break;
                    }
                    List<Integer> per = new LinkedList<>(li);
                    per.add(j, num);
                    res.add(per);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LE047PermuteUniqueIter p = new LE047PermuteUniqueIter();
        int[] arr = new int[]{1,1,2,2};
        System.out.println(p.permuteUnique(arr));
    }
}
