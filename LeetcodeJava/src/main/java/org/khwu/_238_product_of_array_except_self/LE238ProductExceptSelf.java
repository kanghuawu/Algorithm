package org.khwu._238_product_of_array_except_self;

public class LE238ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int ri = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] *= ri;
            ri *= nums[i];
        }
        return res;
    }
    // My
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        int ze1 = -1;
//        int ze2 = -1;
//        int prod = 1;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 0) {
//                if (ze1 == -1) {
//                    ze1 = i;
//                } else if (ze2 == -1) {
//                    return res;
//                }
//            } else {
//                prod *= nums[i];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (ze1 == -1) res[i] = prod / nums[i];
//            else if (ze1 == i) res[i] = prod;
//            else res[i] = 0;
//        }
//        return res;
//    }
}
