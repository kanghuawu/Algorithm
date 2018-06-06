package org.khwu._080_remove_duplicate_from_sorted_array_ii;

public class LE080RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        final int k = 2;
        int n = nums.length;
        int i = 1;
        int count = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j] == nums[j-1]) {
                if (count < k) {
                    nums[i] = nums[j];
                    i++;
                    count++;
                }
            } else {
                nums[i] = nums[j];
                i++;
                count = 1;
            }
        }
        return i;
    }
}
