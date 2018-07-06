package org.khwu._114_flatten_binary_tree_to_linked_list;

import org.khwu.utility.TreeNode;

public class LE114Recursion {
    private TreeNode recursion(TreeNode root) {
        if (root == null) return null;
        TreeNode originLeft = root.left;
        TreeNode originRight = root.right;
        TreeNode fromLeft = recursion(root.left);
        TreeNode fromRight = recursion(root.right);
        if (fromLeft != null) {
            root.right = originLeft;
            fromLeft.right = originRight;
            root.left = null;
        }

        return fromRight == null ? (fromLeft == null ? root : fromLeft) : fromRight;
    }
    public void flatten(TreeNode root) {
        recursion(root);
    }
}
