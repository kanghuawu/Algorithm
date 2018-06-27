package org.khwu._653_two_sum_iv_input_is_a_bst;

import org.khwu.utility.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LE653FindTargetStack {
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> lTree = new LinkedList<>();
        Deque<TreeNode> rTree = new LinkedList<>();
        enqueue(lTree, root, true);
        enqueue(rTree, root, false);
        while (lTree.peekLast() != rTree.peekLast()) {
            TreeNode lNode = lTree.peekLast();
            TreeNode rNode = rTree.peekLast();
            if (lNode.val + rNode.val == k) return true;
            if (lNode.val + rNode.val < k) enqueue(lTree, lTree.removeLast().right, true);
            else enqueue(rTree, rTree.removeLast().left, false);
        }
        return false;
    }

    private void enqueue(Deque<TreeNode> deque, TreeNode root, boolean left) {
        while (root != null) {
            if (left) {
                deque.addLast(root);
                root = root.left;
            } else {
                deque.addLast(root);
                root = root.right;
            }
        }
    }
}
