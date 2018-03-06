package org.khwu._795_nums_of_subarrays_with_bouned_max;

public class LE795NumSubarrayBoundedMax {

    // Greedy
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L-1);
    }

    private int count(int[] A, int max) {
        int re = 0;
        int cur = 0;
        for (int n : A) {
            if (n <= max) {
                cur++;
            } else {
                cur = 0;
            }
            re += cur;
        }
        return re;
    }

    // Greedy ref: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/discuss/117595/Short-Java-O(n)-Solution
//    public int numSubarrayBoundedMax(int[] A, int L, int R) {
//        int re = 0;
//        int count = 0;
//        int j = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] >= L && A[i] <= R) {
//                count = i-j+1;
//                re += i-j+1;
//            } else if (A[i] < L) {
//                re += count;
//            } else {
//                count = 0;
//                j = i + 1;
//            }
//        }
//        return re;
//    }
}
