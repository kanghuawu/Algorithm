package org.khwu._128_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

public class LE128LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        for (int num : set) {
            if (set.contains(num - 1)) continue;
            int nxt = num + 1;
            int max = 1;
            while (set.contains(nxt)) {
                max++;
                nxt++;
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
