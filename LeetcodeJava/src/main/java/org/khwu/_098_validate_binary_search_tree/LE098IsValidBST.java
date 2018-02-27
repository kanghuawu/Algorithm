package org.khwu._098_validate_binary_search_tree;

import utility.TreeNode;

import java.util.Stack;

public class LE098IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> st = new Stack<>();

        long curMin = Long.MIN_VALUE;
        for (TreeNode n = root; n != null; n = n.left) {
            st.push(n);
        }
        while (!st.isEmpty()) {
            TreeNode mid = st.pop();
            // System.out.printf("%d ", mid.val);
            if (mid.val <= curMin) return false;
            curMin = mid.val;
            if (mid.right != null) {
                for (TreeNode n = mid.right; n != null; n = n.left) {
                    st.push(n);
                }
            }
        }
        return true;
    }
}
