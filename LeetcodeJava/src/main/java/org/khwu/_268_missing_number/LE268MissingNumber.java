package org.khwu._268_missing_number;

public class LE268MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++){
            res ^= nums[i];
            res ^= i;
        }
        res ^= n;
        return res;
    }
}
