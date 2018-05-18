package org.khwu._646_maximum_length_of_pair_chain;

import java.util.Arrays;

public class LE646FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null && pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int pt = pairs[0][1];
        int res = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pt >= pairs[i][0]) continue;
            res ++;
            pt = pairs[i][1];
        }
        return res;
    }
}
