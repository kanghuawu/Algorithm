package org.khwu._404_sum_of_left_leaves;

import org.khwu.utility.TreeNode;

public class LE404SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null || (root.left == null && root.right == null)) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        } else {
            res += sumOfLeftLeaves(root.left);
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }
}
