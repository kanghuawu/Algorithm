package org.khwu._199_binary_tree_right_side_view;

import org.khwu.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LE199RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) res.add(root.val);

        dfs(res, root.right, level+1);
        dfs(res, root.left, level+1);
    }
}
