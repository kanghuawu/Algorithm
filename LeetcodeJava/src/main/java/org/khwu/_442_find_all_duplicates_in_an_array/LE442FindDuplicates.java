package org.khwu._442_find_all_duplicates_in_an_array;

import java.util.LinkedList;
import java.util.List;

public class LE442FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int j = 0; j < n ; j++) {
            if (j + 1 != nums[j]) res.add(nums[j]);
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
