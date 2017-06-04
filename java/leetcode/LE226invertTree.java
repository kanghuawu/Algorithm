package leetcode;

import utility.TreeNode;

public class LE226invertTree {
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
    	LE226invertTree test = new LE226invertTree();
    	TreeNode tree = TreeNode.TreeNode1();
    	TreeNode intree = test.invertTree(tree);
    	System.out.println(intree.right.right.left.val);
    }
}
