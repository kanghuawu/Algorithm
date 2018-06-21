package org.khwu._257_binary_tree_paths;

import org.khwu.utility.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LE257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        if (root.left == null && root.right == null) {
            int le = sb.length();
            sb.append(root.val);
            res.add(sb.toString());
            sb.setLength(le);
            return;
        }
        int le = sb.length();
        sb.append(root.val);
        sb.append("->");
        if (root.left != null) dfs(root.left, sb, res);
        if (root.right != null) dfs(root.right, sb, res);
        sb.setLength(le);
    }
}
