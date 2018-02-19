package org.khwu._769_max_chunks_to_make_sorted;

import java.util.HashMap;
import java.util.Map;

public class LE769MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr[i]) continue;
            int hi = map.getOrDefault(i, 0);
            map.put(Math.min(i, arr[i]), Math.max(i, Math.max(arr[i], hi)));
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        // System.out.println(map);
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(map.getOrDefault(i, -1), max);
            if (max <= i) count++;
        }
        return count;
    }
}
