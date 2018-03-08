package org.khwu._075_sort_colors;

public class LE075SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, k = n-1;
        for (;j <= k; j++) {
            if (i < j && nums[j] == 0) swap(nums, i++, j--);
            else if (j < k && nums[j] == 2) swap(nums, j--, k--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
