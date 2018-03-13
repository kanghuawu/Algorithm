package org.khwu._152_maximum_product_subarray;

public class LE152MaxProduct {
    public int maxProduct(int[] nums) {
        int max = 0;
        int n = nums.length;
        if (nums == null || n == 0) return max;

        int maxPre = nums[0];
        int minPre = nums[0];
        max = nums[0];

        for (int i = 1; i < n; i++) {
            int tmpMax = maxPre * nums[i];
            int tmpMin = minPre * nums[i];
            int curMax = Math.max(Math.max(nums[i], tmpMax), tmpMin);
            int curMin = Math.min(Math.min(nums[i], tmpMin), tmpMax);
            maxPre = curMax;
            minPre = curMin;
            max = Math.max(max, curMax);
        }

        return max;
    }
}
