package leetcode._030_next_permutation;

public class LE031NextPermutation {
    // MY 2017-1-3
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int i = len - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                break;
            }
        }
        if (i == 0) {
            sort(nums, 0, len - 1);
            return;
        }
        int j = len - 1;
        for (; nums[j] <= nums[i-1]; j--) ;
        // System.out.println(i + " " + j);
        swap(nums, i - 1, j);
        sort(nums, i, len - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    private void sort(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    // MY (corner cases!!) ref: https://leetcode.com/problems/next-permutation/solution/
//    public void nextPermutation(int[] nums) {
//
//        int i = nums.length - 2;
//
//        if (i < 0) return;
//
//        while (i >= 0 && nums[i] >= nums[i + 1]) {
//            i--;
//        }
//
//        int j = i + 1;
//        int bigger = Integer.MAX_VALUE;
//        int biggerIdx = j;
//        while (i >= 0 && j < nums.length) {
//            if (nums[j] > nums[i] && bigger >= nums[j]) {
//                biggerIdx = j;
//                bigger = nums[j];
//            }
//            j++;
//        }
//
//        // System.out.println(i + " " + j + " " + biggerIdx);
//
//        if (i >= 0)
//            swap(nums, i, biggerIdx);
//
//        reverse(nums, i + 1);
//
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//
//    private void reverse(int[] nums, int k) {
//        for (int i = k, j = nums.length - 1; i < j; i++, j-- ) {
//            swap(nums, i, j);
//        }
//    }
}
