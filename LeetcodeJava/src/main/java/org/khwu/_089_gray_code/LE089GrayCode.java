package org.khwu._089_gray_code;

import java.util.ArrayList;
import java.util.List;

public class LE089GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size-1; j >= 0; j--) {
                res.add(res.get(j) | 1 << i);
            }
        }
        return res;
    }
}
