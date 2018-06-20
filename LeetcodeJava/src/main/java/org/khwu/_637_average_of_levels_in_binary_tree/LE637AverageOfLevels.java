package org.khwu._637_average_of_levels_in_binary_tree;

import org.khwu.utility.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LE637AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            Deque<TreeNode> tmp = new LinkedList<>();
            double sum = 0;
            int count = 0;
            while (!q.isEmpty()) {
                TreeNode node = q.removeFirst();
                if (node.left != null) tmp.addLast(node.left);
                if (node.right != null) tmp.addLast(node.right);
                sum += node.val;
                count++;
            }
            if (count != 0) {
                res.add(sum / (double) count);
            }
            q = tmp;
        }

        return res;
    }
}
