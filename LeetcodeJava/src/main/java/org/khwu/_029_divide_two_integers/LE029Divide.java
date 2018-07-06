package org.khwu._029_divide_two_integers;

public class LE029Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend > 0 && divisor > 0) return helper(-dividend, -divisor);
        if (dividend > 0) return -helper(-dividend, divisor);
        if (divisor > 0) return -helper(dividend, -divisor);
        return helper(dividend, divisor);
    }

    private int helper(int dividend, int divisor) {
        // -dividend < -divisor
        if (dividend > divisor) return 0;

        int pow = 0;
        while ((divisor << pow) >= dividend && (divisor << pow >> pow == divisor) && pow < 31) {
            pow++;
        }
        int res = dividend - (divisor << pow - 1);
        // -res < -divisor
        if (res > divisor) return 1 << (pow - 1);
        return (1 << (pow - 1)) + helper(res, divisor);
    }
}
