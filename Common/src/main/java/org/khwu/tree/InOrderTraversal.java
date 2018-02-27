package org.khwu.tree;

import java.util.Stack;

public class InOrderTraversal {
    public static void traversalDFS(TreeNode node) {
        if (node == null) return;
        traversalDFS(node.left);
        System.out.printf("%d ", node.val);
        traversalDFS(node.right);
    }

    public static void traversalIter(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> st = new Stack<>();

        for (TreeNode n = node; n != null; n = n.left) {
            st.push(n);
        }
        while (!st.isEmpty()) {
            TreeNode mid = st.pop();
            System.out.printf("%d ", mid.val);
            if (mid.right != null) {
                for (TreeNode n = mid.right; n != null; n = n.left) {
                    st.push(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        traversalDFS(TreeNode.nodes());
        System.out.println();
        traversalIter(TreeNode.nodes());
    }
}
