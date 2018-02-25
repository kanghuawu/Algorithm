package org.khwu._788_rotate_digits;

public class LE788RotateDigits {
    public int rotatedDigits(int N) {
        int x = 0;
        for (int i = 1; i <= N; i++) {
            if (isGood(i)) x++;
        }
        return x;
    }

    private boolean isGood(int num) {
        for (int i = num; i > 0; i /= 10) {
            int tmp = i%10;
            if (tmp == 3 || tmp == 4 || tmp == 7) return false;
        }
        for (int i = num; i > 0; i /= 10) {
            int tmp = i%10;
            if (tmp == 2 || tmp == 5 || tmp == 6 || tmp == 9) return true;
        }
        return false;
    }
}
