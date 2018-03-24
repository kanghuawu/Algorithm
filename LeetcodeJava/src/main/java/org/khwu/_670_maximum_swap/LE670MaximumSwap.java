package org.khwu._670_maximum_swap;

public class LE670MaximumSwap {
    public int maximumSwap(int num) {
        char[] chAr = String.valueOf(num).toCharArray();
        int[] bu = new int[10];
        int n = chAr.length;
        for (int i = 0; i < n; i++) {
            bu[chAr[i] - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 9; j > chAr[i] - '0'; j--) {
                if (bu[j] > i) {
                    char tmp = chAr[i];
                    chAr[i] = chAr[bu[j]];
                    chAr[bu[j]] = tmp;
                    return Integer.parseInt(new String(chAr));
                }
            }
        }
        return num;
    }
}
