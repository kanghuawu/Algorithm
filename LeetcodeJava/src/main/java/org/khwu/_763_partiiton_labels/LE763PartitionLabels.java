package org.khwu._763_partiiton_labels;

import java.util.LinkedList;
import java.util.List;

public class LE763PartitionLabels {
    public List<Integer> partitionLabels(String S) {

        int[] map = new int[26];
        int n = S.length();
        for (int i = 0; i < n; i++) {
            map[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new LinkedList<>();
        int s = 0;
        int e = 0;
        for (int i = 0; i < n; i++) {
            e = Math.max(e, map[S.charAt(i) - 'a']);
            if (e == i) {
                res.add(e - s + 1);
                s = e + 1;
            }
        }
        return res;
    }
}
