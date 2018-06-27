package org.khwu._275_h_index_ii;

public class LE275HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int le = 0;
        int ri = n - 1;
        int mid = 0;
        while (le <= ri) {
            mid = le + (ri - le) / 2;
            if (citations[mid] == n - mid) return n - mid;
            if (citations[mid] > n - mid) ri = mid - 1;
            else le = mid + 1;
        }
        // System.out.println(le +" "+ mid +" "+ ri);
        return n - le;
    }
}
