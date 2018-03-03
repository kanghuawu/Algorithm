package org.khwu._239_sliding_window_maximum;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LE239MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length - k + 1;
        int[] res = new int[n];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int le = i - k + 1;
            while (!q.isEmpty() && q.peekFirst() < le) q.pollFirst();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.offerLast(i);
            if (le >= 0) res[le] = nums[q.peekFirst()];
        }
        return res;
    }
}
