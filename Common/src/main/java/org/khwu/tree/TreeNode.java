package org.khwu.tree;

import lombok.Data;

@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode nodes() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n2.setLeft(n1);
        n2.setRight(n3);
        n4.setLeft(n2);
        n4.setRight(n6);
        n6.setLeft(n5);
        n6.setRight(n7);
        return n4;
    }
}
