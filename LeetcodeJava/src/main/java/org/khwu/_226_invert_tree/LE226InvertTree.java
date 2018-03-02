package org.khwu._226_invert_tree;

import utility.TreeNode;

public class LE226InvertTree {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return null;
    	else{
       		TreeNode le = invertTree(root.right);
    		TreeNode ri = invertTree(root.left);
    		root.left = le;
    		root.right = ri;
    	}
    	return root;
    }
    public static void main(String[] args){
    	LE226InvertTree test = new LE226InvertTree();
    	TreeNode tree = TreeNode.node1();
    	TreeNode intree = test.invertTree(tree);
    	System.out.println(intree.right.right.left.val);
    }
}
