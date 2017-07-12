package notebook;

import java.util.ArrayDeque;
import java.util.Deque;
import utility.TreeNode;

public class StackQueue {
	public static void DFSStack(TreeNode root){
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			if(root.right != null)
				stack.push(root.left);
			if(root.left != null)
				stack.push(root.right);
			System.out.println(root.val);
		}
	}
	
	public static void DFSRecursive(TreeNode root){
		if(root == null) return;
//		System.out.println(root.val);   // pre order
		if(root.left != null) 
			DFSRecursive(root.left);
		System.out.println(root.val);   // in order
		if(root.right != null)
			DFSRecursive(root.right);
//		System.out.println(root.val);   // post order
	}
	
	public static void BFSStack(TreeNode root){
		
	}
	
	public static void BFSRecursive(TreeNode root){
		
	}
	
	public static void main(String[] args){
		StackQueue.DFSStack(TreeNode.TreeNode2());
	}
}
