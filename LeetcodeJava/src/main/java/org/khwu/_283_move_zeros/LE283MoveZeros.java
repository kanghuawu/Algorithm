package org.khwu._283_move_zeros;

public class LE283MoveZeros {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            while (i < n && nums[i] != 0) i++;
            while (j < n && nums[j] == 0) j++;
            if (i < j && j < n) {
                swap(nums, i, j);
            }
            j++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
