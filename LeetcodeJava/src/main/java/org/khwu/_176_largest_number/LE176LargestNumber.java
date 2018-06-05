package org.khwu._176_largest_number;

import java.util.Arrays;

public class LE176LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
            x |= nums[i];
        }
        if (x == 0) return "0";
        Arrays.sort(strs, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return -s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
