package org.khwu;

public class LE026RemoveDuplicates {
    // MY
//    public int removeDuplicates(int[] nums) {
//        int len = 0;
//        for (int i = 0; i < nums.length; i++) {
//
//            while (i < nums.length - 1 && nums[i] == nums[i + 1])
//                i++;
//
//            if (i != len)
//                swap(nums, i, len);
//
//            len++;
//
//        }
//        System.out.println(len);
//        return len;
//    }
//    private void swap(int[] nums, int i, int j) {
//        if (i == j) return;
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[len] != nums[i])
                nums[++len] = nums[i];
        }
        return ++len;
    }
}
