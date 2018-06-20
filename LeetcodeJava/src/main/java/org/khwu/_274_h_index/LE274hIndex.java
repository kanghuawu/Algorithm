package org.khwu._274_h_index;

public class LE274hIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n+1];
        for (int num : citations) {
            if (num > n) bucket[n]++;
            else bucket[num]++;
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            if (bucket[i] != 0) count += bucket[i];
            if (count >= i) return i;
        }

        return 0;
    }
}
