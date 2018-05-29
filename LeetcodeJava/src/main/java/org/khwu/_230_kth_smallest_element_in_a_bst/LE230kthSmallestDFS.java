package org.khwu._230_kth_smallest_element_in_a_bst;

import org.khwu.utility.TreeNode;

public class LE230kthSmallestDFS {
    private int res;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null || k < 0) return;
        dfs(root.left);
        k--;
        if (k == 0) res = root.val;
        dfs(root.right);
    }
}
