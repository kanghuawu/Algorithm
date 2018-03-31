package org.khwu._282_expression_add_operators;

import java.util.LinkedList;
import java.util.List;

public class LE282AddOperators {

    /*
    ref: https://leetcode.com/problems/expression-add-operators/discuss/71897/Java-AC-solution-19ms-beat-100.00.
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if (num.length() == 0) return res;
        char[] nums = num.toCharArray();
        char[]  sb = new char[2 * num.length()];
        long n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = n * 10 + nums[i] - '0';
            sb[i] = nums[i];
            dfs(res, sb, i + 1, i + 1, 0, n, nums, target);
            if (n == 0) break;
        }
        return res;
    }

    private void dfs(List<String> res, char[] sb, int pt, int idx, long prev, long cur, char[] nums, int target) {
        if (idx == nums.length) {
            if (prev + cur == target) res.add(new String(sb, 0, pt));
            return;
        }
        long n = 0;
        int j = pt + 1;
        for (int i = idx; i < nums.length; i++) {
            n = n * 10 + nums[i] - '0';
            sb[j++] = nums[i];
            sb[pt] = '*';
            dfs(res, sb, j, i + 1, prev, cur * n, nums, target);
            sb[pt] = '+';
            dfs(res, sb, j, i + 1, prev + cur, n, nums, target);
            sb[pt] = '-';
            dfs(res, sb, j, i + 1, prev + cur, -n, nums, target);
            if (n == 0) break;
        }
    }
}
