package leetcode;

public class LE053MaxSubArray {
    public int maxSubArray(int[] nums) {
        int accu = 0;
        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            accu += nums[i];
            if (i == 0) {
                max = accu;
            } else if (accu - min > max) {
                max = accu - min;
            }
            if (accu < min) {
                min = accu;
            }
        }
        return max;
    }
}
