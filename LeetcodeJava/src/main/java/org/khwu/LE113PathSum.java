package org.khwu;

import org.khwu.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LE113PathSum {
    private List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList();
        dfs(root, sum, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return ;
        }
        list.add(root.val);
        if (root.right == null && root.left == null && sum - root.val == 0) {
            res.add(new ArrayList(list));
        } else {
            dfs(root.right, sum - root.val, list);
            dfs(root.left, sum - root.val, list);
        }
        list.remove(list.size() - 1);
    }
}
