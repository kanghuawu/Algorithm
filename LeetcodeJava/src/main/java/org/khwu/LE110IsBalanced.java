package org.khwu;

import utility.TreeNode;

public class LE110IsBalanced {
	public boolean isBalanced(TreeNode root) {
	    if(root==null){
	        return true;
	    }
	    return height(root)!=-1;
	    
	}
	public int height(TreeNode node){
	    if(node==null){
	        return 0;
	    }
	    int lH=height(node.left);
	    if(lH==-1){
	        return -1;
	    }
	    int rH=height(node.right);
	    if(rH==-1){
	        return -1;
	    }
	    if(lH-rH<-1 || lH-rH>1){
	        return -1;
	    }
	    return Math.max(lH,rH)+1;
	}
    
  
    
    public static void main(String[] args){
    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(3);
//    	TreeNode t4 = new TreeNode(4);
//    	TreeNode t5 = new TreeNode(5);
//    	TreeNode t6 = new TreeNode(6);
//    	TreeNode t7 = new TreeNode(7);
    	t1.left = t2;
    	t2.right = t3;
//    	t3.left = t6;
//    	t3.right = t7;
    	LE110IsBalanced test = new LE110IsBalanced();
    	System.out.println(test.isBalanced(t1));
    	
    }
}
