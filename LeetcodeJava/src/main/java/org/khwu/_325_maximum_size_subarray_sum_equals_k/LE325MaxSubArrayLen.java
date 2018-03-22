package org.khwu._325_maximum_size_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

public class LE325MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int acc = 0;
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        for (int i = 0; i < n; i++) {
            acc += nums[i];
            pos.putIfAbsent(acc, i);
            res = Math.max(res, i - pos.getOrDefault(acc - k, i));
        }
        return res;
    }
}
