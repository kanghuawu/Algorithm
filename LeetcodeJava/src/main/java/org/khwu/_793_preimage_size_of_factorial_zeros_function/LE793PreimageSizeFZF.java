package org.khwu._793_preimage_size_of_factorial_zeros_function;

public class LE793PreimageSizeFZF {
    // ref https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/discuss/117649/4ms-Java-Math-Solution
    public int preimageSizeFZF(int K) {
        if (K < 5) return 5;
        int d = 0;
        while (d * 5 + 1 <= K) d = d * 5 + 1;
        if (K / d == 5) return 0;
        return preimageSizeFZF(K % d);
    }
}
