package org.khwu;

public class LE581FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        int start = 0;
        while (start + 1 < n && nums[start] <= nums[start + 1]) {
            start++;
        }
        int min = nums[start];
        for (int i = start; i < n; i++) {
            min = Math.min(min, nums[i]);
        }

        int end = nums.length - 1;
        while (end > 0 && nums[end] >= nums[end - 1]) {
            end--;
        }
        int max = nums[end];
        for (int i = end - 1; i >= start; i--) {
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < start; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }
        for (int i = n - 1; i > end ;i --) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }
        return Math.max(end - start + 1, 0);
    }
}
