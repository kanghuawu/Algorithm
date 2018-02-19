package org.khwu._078_subsets;

import java.util.ArrayList;
import java.util.List;

public class LE078SubsetsBit {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < Math.pow(2, size); i++) {
            List<Integer> tmp = new ArrayList<>();
            int iter = i;
            int idx = size - 1;
            while (iter != 0) {
                if ((iter & 1) == 1) {
                    tmp.add(nums[idx]);
                }
                idx--;
                iter >>= 1;
            }
            res.add(tmp);
        }

        return res;
    }

    // ref: https://leetcode.com/problems/subsets/discuss/27543/
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        int size = nums.length;
//        for (int i = 0; i < 1 << size; i++) {
//            List<Integer> tmp = new ArrayList<>();
//            for (int j = 0; j < size; j++) {
//                if (((1 << j) & i) != 0) {
//                    tmp.add(nums[j]);
//                }
//            }
//            res.add(tmp);
//        }
//        return res;
//    }
}
