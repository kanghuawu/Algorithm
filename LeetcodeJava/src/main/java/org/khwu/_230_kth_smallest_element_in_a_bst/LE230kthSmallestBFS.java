package org.khwu._230_kth_smallest_element_in_a_bst;

import org.khwu.utility.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LE230kthSmallestBFS {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        for (TreeNode n = stack.removeLast(); n != null; n = n.left) {
            stack.addLast(n);
        }
        while (true) {
            TreeNode node = stack.removeLast();
            k--;
            if (k == 0) return node.val;
            if (node.right != null) {
                stack.addLast(node.right);
                for (TreeNode n = stack.removeLast(); n != null; n = n.left) {
                    stack.addLast(n);
                }
            }
        }
    }
}
