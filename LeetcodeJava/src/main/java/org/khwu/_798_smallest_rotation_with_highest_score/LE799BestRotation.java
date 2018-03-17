package org.khwu._798_smallest_rotation_with_highest_score;

public class LE799BestRotation {
    public int bestRotation(int[] A) {
        int n = A.length;
        int[] change = new int[n];
        for (int i = 0; i < n; i++) {
            change[(i - A[i] + 1 + n) % n]--;
        }

        int idx = 0;
        for (int i = 1; i < n; i++) {
            change[i] += change[i-1] + 1;
            if (change[i] > change[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
