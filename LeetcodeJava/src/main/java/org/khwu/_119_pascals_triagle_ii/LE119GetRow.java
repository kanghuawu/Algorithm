package org.khwu._119_pascals_triagle_ii;

import java.util.ArrayList;
import java.util.List;

public class LE119GetRow {
    public List<Integer> getRow(int rowIndex) {
        int n = rowIndex + 1;
        int[] arr = new int[n];
        arr[0] = 1;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            int pre = arr[0];
            for (int j = 1; j <= i; j++) {
                cur = arr[j];
                arr[j] += pre;
                pre = cur;
            }
        }
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) res.add(arr[i]);
        return res;
    }
}
