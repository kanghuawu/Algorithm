package org.khwu._398_random_pick_index;

import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> cache;
    private Random rand;
    public Solution(int[] nums) {
        int n = nums.length;
        cache = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < n; i++) {
            List<Integer> li = cache.getOrDefault(nums[i], new ArrayList<>());
            cache.put(nums[i], li);
            li.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> li = cache.get(target);
        int idx = rand.nextInt(li.size());
        return li.get(idx);
    }
}