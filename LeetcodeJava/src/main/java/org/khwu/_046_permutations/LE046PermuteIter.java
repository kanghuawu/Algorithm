package org.khwu._046_permutations;

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

    // ref: https://leetcode.com/problems/permutations/discuss/18444/?page=1
//    private static final int[] FACT = { // 479001600 < 2147483647 < 6227020800
//            1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600
//    };
//    public List<List<Integer>> permute(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>(nums.length);
//        for (int k = 0; k < FACT[nums.length]; ++k) {
//            result.add(permutation(nums, k));
//        }
//        return result;
//    }
//    List<Integer> permutation(int[] nums, int k) {
//        // k %= FACT[nums.length]; // in case you want to use it elsewhere
//        List<Integer> source = toList(nums);
//        List<Integer> result = new ArrayList(nums.length);
//        while (!source.isEmpty()) {
//            int f = FACT[source.size() - 1];
//            result.add(source.remove(k / f));
//            k %= f;
//        }
//        return result;
//    }
//    List<Integer> permutation(int[] nums, int k) {
//        int[] source = nums.clone();
//        int len = nums.length;
//        List<Integer> result = new ArrayList(len);
//        while (len-- > 0) {
//            int f = FACT[len];
//            result.add(source[k / f]);
//            source[k / f] = source[len];
//            k %= f;
//        }
//        return result;
//    }
}
