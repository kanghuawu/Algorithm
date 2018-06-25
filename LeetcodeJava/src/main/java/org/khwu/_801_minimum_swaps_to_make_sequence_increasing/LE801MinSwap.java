package org.khwu._801_minimum_swaps_to_make_sequence_increasing;

public class LE801MinSwap {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int swap = 0;
        int notSwap = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) continue;
            int preSwap = swap;
            int preNotSwap = notSwap;
            if (i > 0 && (B[i] <= B[i-1] || A[i] <= A[i-1])) {
                swap = preNotSwap + 1;
                notSwap = preSwap;
            } else if (i > 0 && (B[i] <= A[i-1] || A[i] <= B[i-1])) {
                swap = preSwap + 1;
                notSwap = preNotSwap;
            } else {
                swap = Math.min(preSwap, preNotSwap) + 1;
                notSwap = Math.min(preSwap, preNotSwap);
            }
        }
        return Math.min(swap, notSwap);
    }
}
