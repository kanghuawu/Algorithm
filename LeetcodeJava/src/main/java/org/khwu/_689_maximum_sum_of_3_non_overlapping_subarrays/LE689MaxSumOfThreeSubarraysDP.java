package org.khwu._689_maximum_sum_of_3_non_overlapping_subarrays;

import java.util.Arrays;

public class LE689MaxSumOfThreeSubarraysDP {

    // ref: https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/108231/C++Java-DP-with-explanation-O(n)
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[3];
        for (int i = 0; i < n; i++) {
            sum[i+1] += sum[i] + nums[i];
        }

        for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
            if (sum[i+1] - sum[i+1-k] > tot) {
                left[i] = i+1-k;
                tot = sum[i+1] - sum[i+1-k];
            } else {
                left[i] = left[i-1];
            }
        }

        right[n-k] = n-k;
        for (int i = n-k-1, tot = sum[n] - sum[n-k];i >= 0; i--) {
            if (sum[i+k] - sum[i] >= tot) {
                right[i] = i;
                tot = sum[i+k] - sum[i];
            } else {
                right[i] = right[i+1];
            }
        }
        System.out.println(Arrays.toString(sum));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int max = 0;
        for (int i = k; i <= n-2*k; i++) {
            int l = left[i-1];
            int r = right[i+k];
            int tot = sum[i+k] - sum[i] + sum[l+k] - sum[l] + sum[r+k] - sum[r];
            if (tot > max) {
                max = tot;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}
