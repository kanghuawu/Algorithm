package org.khwu._653_two_sum_iv_input_is_a_bst;

import org.khwu.utility.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LE653FindTargetSet {
    public boolean findTarget(TreeNode root, int k) {
        return search(root, k, new HashSet<>());
    }

    private boolean search(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return search(root.left, k, set) || search(root.right, k, set);
    }
}
