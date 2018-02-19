package org.khwu;

public class LE034SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] > target)
                j = mid - 1;
            else if (nums[mid] < target)
                i = mid + 1;
            else
                break;
        }

        if (nums[mid] != target)
            return new int[]{-1, -1};
        int start = mid;
        int end = mid;
        // System.out.println(mid);
        while (start >= 0 && nums[start] == target)
            start--;

        while (end < nums.length && nums[end] == target)
            end++;
        // System.out.println(start + " " + end);
        return new int[]{Math.max(0, start + 1), Math.min(nums.length, end - 1)};

    }
}
