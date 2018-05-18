package org.khwu._374_top_k_frequent_elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LE374TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new LinkedList[n+1];
        for (int key : count.keySet()) {
            int val = count.get(key);
            List<Integer> li = bucket[val];
            if (bucket[val] == null) li = new LinkedList<>();
            li.add(key);
            bucket[val] = li;
        }

        List<Integer> res = new LinkedList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            res.addAll(bucket[i]);
            if (res.size() == k) break;
        }

        return res;
    }
}
