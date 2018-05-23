package org.khwu._337_house_robber_iii;

import org.khwu.utility.TreeNode;

public class LE337Rob {
    public int rob(TreeNode root) {
        int[] dp = dfs(root);

        return Math.max(dp[0], dp[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] le = dfs(root.left);
        int[] ri = dfs(root.right);
        return new int[]{Math.max(Math.max(le[1] + ri[1], le[1] + ri[0]),
                Math.max(le[0] + ri[0], le[0] + ri[1])),
                root.val + le[0] + ri[0]};
    }
}
