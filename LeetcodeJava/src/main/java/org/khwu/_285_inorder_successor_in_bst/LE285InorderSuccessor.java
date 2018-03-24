package org.khwu._285_inorder_successor_in_bst;

import org.khwu.utility.TreeNode;

public class LE285InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        TreeNode res = root;
        while (res != null && res.val <= p.val) res = res.right;
        if (res == null) return null;
        TreeNode tmp = res;
        if (tmp.left != null) tmp =  inorderSuccessor(tmp.left, p);
        return tmp == null ? res : tmp;
    }
}
