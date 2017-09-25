package leetcode;

public class LE031NextPermutation {
    // MY (corner cases!!) ref: https://leetcode.com/problems/next-permutation/solution/
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        if (i < 0) return;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        int j = i + 1;
        int bigger = Integer.MAX_VALUE;
        int biggerIdx = j;
        while (i >= 0 && j < nums.length) {
            if (nums[j] > nums[i] && bigger >= nums[j]) {
                biggerIdx = j;
                bigger = nums[j];
            }
            j++;
        }

        // System.out.println(i + " " + j + " " + biggerIdx);

        if (i >= 0)
            swap(nums, i, biggerIdx);

        reverse(nums, i + 1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int k) {
        for (int i = k, j = nums.length - 1; i < j; i++, j-- ) {
            swap(nums, i, j);
        }
    }
}
