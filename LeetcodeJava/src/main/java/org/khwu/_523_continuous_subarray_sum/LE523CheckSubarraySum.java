package org.khwu._523_continuous_subarray_sum;

import java.util.HashMap;
import java.util.Map;

public class LE523CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k < 0) k = -k;
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int n = nums.length;
        int acc = 0;
        for (int i = 0; i < n; i++) {
            acc += nums[i];
            if (k != 0) acc %= k;
            if (pos.containsKey(acc) && i - pos.get(acc) > 1) return true;
            if (!pos.containsKey(acc)) pos.put(acc, i);
        }
        return false;
    }
}
