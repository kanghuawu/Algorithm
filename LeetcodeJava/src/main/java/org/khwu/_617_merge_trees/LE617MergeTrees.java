package org.khwu._617_merge_trees;

import org.khwu.utility.TreeNode;

public class LE617MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode n = new TreeNode(0);
        if (t1 == null && t2 != null) {
            n.val = t2.val;
            n.right = mergeTrees(null, t2.right);
            n.left = mergeTrees(null, t2.left);
        } else if (t1 != null && t2 == null) {
            n.val = t1.val;
            n.right = mergeTrees(t1.right, null);
            n.left = mergeTrees(t1.left, null);
        } else {
            n.val = t1.val += t2.val;
            n.right = mergeTrees(t1.right, t2.right);
            n.left = mergeTrees(t1.left, t2.left);
        }

        return n;
    }

    // not creating new node
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) {
//            return null;
//        } else if (t1 == null && t2 != null) {
//            return t2;
//        } else if (t1 != null && t2 == null) {
//            return t1;
//        } else {
//            t1.val += t2.val;
//            t1.right = mergeTrees(t1.right, t2.right);
//            t1.left = mergeTrees(t1.left, t2.left);
//            return t1;
//        }
//    }
}
