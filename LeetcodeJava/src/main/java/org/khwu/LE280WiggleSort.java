package org.khwu;

public class LE280WiggleSort {

    // ref: https://discuss.leetcode.com/topic/23877/4-lines-o-n-c/2
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            /*
            if (i % 2 == 1 && nums[i] < nums[i - 1])
                swap(nums, i);
            if (i % 2 == 0 && nums[i] > nums[i - 1])
                swap(nums, i);
            */

            if (i % 2 == 1 == nums[i] < nums[i - 1])
                swap(nums, i);
        }
    }

    private void swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = temp;
    }


}
