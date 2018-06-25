package org.khwu._525_contiguous_array;

import java.util.HashMap;
import java.util.Map;

public class LE525FindMaxLength {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int acc = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) acc += -1;
            else if (nums[i] == 1) acc += 1;
            map.putIfAbsent(acc, i);
            res = Math.max(res, i - map.getOrDefault(acc, i));
        }
        return res;
    }
}
