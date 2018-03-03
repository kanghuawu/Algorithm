package org.khwu._783_minimum_distance_between_bst_nodes;

import org.khwu.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LE783MinDiffInBST {
    public int minDiffInBST(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        traversal(root, li);
        // System.out.println(li);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < li.size(); i++) {
            res = Math.min(res, li.get(i) - li.get(i-1));
            if (res == 1) return 1;
        }
        return res;
    }

    private void traversal(TreeNode root, List<Integer> li) {
        if (root == null) return;
        traversal(root.left, li);
        li.add(root.val);
        traversal(root.right, li);
    }
}
