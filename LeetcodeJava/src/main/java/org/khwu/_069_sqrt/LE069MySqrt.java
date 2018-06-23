package org.khwu._069_sqrt;

public class LE069MySqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int le = 1;
        int ri = x;
        int mid;
        while (true) {
            mid = le + (ri - le) / 2;
            if (mid > x / mid) ri = mid - 1;
            else {
                if (mid + 1 > x / (mid + 1)) return mid;
                le = mid + 1;
            }
        }
    }
}
