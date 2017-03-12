package leetcode;

import utility.TreeNode;

public class LE111minDepth {
	public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }else if(root.right == null & root.left == null){
        	return 1;
        }else if(root.right == null || root.left == null){
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }else
        	return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    
    public static void main(String[] args){
    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(3);
    	TreeNode t4 = new TreeNode(4);
    	TreeNode t5 = new TreeNode(5);
    	TreeNode t6 = new TreeNode(6);
    	TreeNode t7 = new TreeNode(7);
//    	t1.left = t2;
//    	t2.right = t3;
//    	t2.left = t4;
//    	t2.right = t5;
//    	t3.left = t6;
//    	t3.right = t7;
    	LE111minDepth test = new LE111minDepth();
    	System.out.println(test.minDepth(t1));
    	
    }
}
