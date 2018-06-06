package org.khwu._456_132_pattern;

public class LE456Find132patternSquare {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int one = nums[0];
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            one = Math.min(one, nums[i]);
            if (one == nums[i]) continue;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > one && nums[i] > nums[j]) return true;
            }
        }
        return false;
    }
}
