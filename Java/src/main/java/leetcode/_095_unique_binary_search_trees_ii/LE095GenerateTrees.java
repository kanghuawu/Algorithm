package leetcode._095_unique_binary_search_trees_ii;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LE095GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n+1];

        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        if (n == 0) return dp[n];
        dp[0].add(null);
        for (int i = 1; i <= n; i++) {
            for (int j = 0, k = i - j - 1; j >= 0 && k >= 0; j++, k--) {
                createTree(i, j, k, dp);
            }
        }
        return dp[n];
    }

    private void createTree(int i, int j, int k, List<TreeNode>[] dp) {
        for (TreeNode nodeJ : dp[j]) {
            for (TreeNode nodeK : dp[k]) {
                TreeNode curr = new TreeNode(i);
                TreeNode upper = copy(nodeJ, 0);
                TreeNode lower = copy(nodeK, i - k - 1);
                curr.left = lower;
                if (upper == null) {
                    dp[i].add(curr);
                } else {
                    dp[i].add(upper);
                    for (; upper.right != null; upper = upper.right);
                    upper.right = curr;
                }

            }
        }
    }

    private TreeNode copy(TreeNode treeNode, int shift) {
        if (treeNode == null) return null;
        TreeNode newTree = new TreeNode(treeNode.val + shift);
        newTree.left = copy(treeNode.left, shift);
        newTree.right = copy(treeNode.right, shift);
        return newTree;
    }
}
