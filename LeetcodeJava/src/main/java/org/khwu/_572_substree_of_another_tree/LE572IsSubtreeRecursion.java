package org.khwu._572_substree_of_another_tree;

import org.khwu.utility.TreeNode;

public class LE572IsSubtreeRecursion {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (helper(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s != null && t != null && s.val == t.val)
            return helper(s.left, t.left) && helper(s.right, t.right);
        return false;
    }
}
