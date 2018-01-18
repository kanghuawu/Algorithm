package leetcode._053_maxium_subarray;

public class LE053MaxSubArray {

    // MY 2017-1-18
    public int maxSubArray(int[] nums) {
        int acc = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            acc += nums[i];
            max = Math.max(max, acc);
            if (acc < 0) {
                acc = 0;
            }
        }
        return max;
    }

//    public int maxSubArray(int[] nums) {
//        int accu = 0;
//        int min = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            accu += nums[i];
//            if (i == 0) {
//                max = accu;
//            } else if (accu - min > max) {
//                max = accu - min;
//            }
//            if (accu < min) {
//                min = accu;
//            }
//        }
//        return max;
//    }
}
