package org.khwu._236_lowest_common_ancestor_of_a_binary_tree;

import org.khwu.utility.TreeNode;

public class LE236LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) return root;
        return l == null ? r : l;
    }
}
