package org.khwu.utility;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }

	public static TreeNode node1(){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode t11 = new TreeNode(11);
		TreeNode t12 = new TreeNode(12);
		TreeNode t13 = new TreeNode(13);
		TreeNode t14 = new TreeNode(14);
		TreeNode t15 = new TreeNode(15);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t4.left = t8;
		t4.right = t9;
		t5.left = t10;
		t5.right = t11;
		t6.left = t12;
		t6.right = t13;
		t7.left = t14;
		t7.right = t15;
		return t1;
	}
	
	public static TreeNode node2(){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode t11 = new TreeNode(11);
		TreeNode t12 = new TreeNode(12);
		TreeNode t13 = new TreeNode(13);
		TreeNode t14 = new TreeNode(14);
		TreeNode t15 = new TreeNode(15);
		t2.left = t1;
		t2.right = t3;
		t4.left = t2;
		t4.right = t6;
		t6.left = t5;
		t6.right = t7;
		t8.left = t4;
		t8.right = t12;
		t12.left = t10;
		t10.left = t9;
		t10.right = t11;
		t12.right = t14;
		t14.left = t13;
		t14.right = t15;
		return t8;
	}
	
	public void print(TreeNode root){
		System.out.print(root.val);
	}
	
//	public void printAll(TreeNode root){
//		if()
//		System.out.print(root.val);
//	}
}
