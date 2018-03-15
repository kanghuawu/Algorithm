package org.khwu._515_find_largest_value_in_each_tree_row;

import org.khwu.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LE515LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            Deque<TreeNode> tmp = new ArrayDeque<>();
            int max = Integer.MIN_VALUE;
            while (!q.isEmpty()) {
                TreeNode node = q.removeLast();
                if (node.left != null) tmp.addLast(node.left);
                if (node.right != null) tmp.addLast(node.right);
                max = Math.max(node.val, max);
            }
            res.add(max);
            q = tmp;
        }
        return res;
    }
}
