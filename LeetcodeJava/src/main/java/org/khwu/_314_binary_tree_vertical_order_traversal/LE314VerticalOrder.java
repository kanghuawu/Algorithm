package org.khwu._314_binary_tree_vertical_order_traversal;

import org.khwu.utility.TreeNode;

import java.util.*;

public class LE314VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        int max = 0;
        int min = 0;
        Deque<NodeIdx> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        q.addLast(new NodeIdx(0, root));
        while (!q.isEmpty()) {
            NodeIdx nodeIdx = q.removeFirst();
            int idx = nodeIdx.idx;
            TreeNode node = nodeIdx.node;
            List<Integer> li = map.getOrDefault(idx, new ArrayList<>());
            li.add(node.val);
            map.put(idx, li);
            if (node.left != null) {
                q.addLast(new NodeIdx(idx - 1, node.left));
                min = Math.min(min, idx - 1);
            }
            if (node.right != null) {
                q.addLast(new NodeIdx(idx + 1, node.right));
                max = Math.max(max, idx + 1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
    }

    private class NodeIdx {
        int idx;
        TreeNode node;
        public NodeIdx(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
    }
}
