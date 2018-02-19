package org.khwu._762_prime_number_set_in_bit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LE762CountPrimeSetBits {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        int count = 0;
        for (int i = L; i <= R; i++) {
            int test = i;
            int ones = 0;
            while (test != 0) {
                ones += test & 1;
                test = test >> 1;
            }
            if (primes.contains(ones)) {
                count += 1;
            }
        }
        return count;
    }
}
