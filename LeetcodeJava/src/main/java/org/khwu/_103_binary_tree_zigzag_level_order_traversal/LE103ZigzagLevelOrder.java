package org.khwu._103_binary_tree_zigzag_level_order_traversal;

import org.khwu.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LE103ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deq = new ArrayDeque<>();
        deq.addLast(root);
        boolean isOdd = true;
        while (!deq.isEmpty()) {
            Deque<TreeNode> tmp = new ArrayDeque<>();
            List<Integer> sub = new ArrayList<>();
            while (!deq.isEmpty()) {
                TreeNode node;
                if (isOdd) {
                    node = deq.removeFirst();
                    if (node.left != null) tmp.addLast(node.left);
                    if (node.right != null) tmp.addLast(node.right);
                } else {
                    node = deq.removeLast();
                    if (node.right != null) tmp.addFirst(node.right);
                    if (node.left != null) tmp.addFirst(node.left);
                }
                sub.add(node.val);
            }
            res.add(sub);
            isOdd = !isOdd;
            deq = tmp;
        }
        return res;
    }
}
