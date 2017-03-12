package leetcode;
import java.util.LinkedList;
import java.util.Queue;

import utility.TreeNode;

public class LE101isSymmetric {
	public boolean isSymmetric(TreeNode root) {
		if(root.left == null || root.left == null ) return root.left == null && root.left == null;
		TreeNode le = root.left;
		TreeNode ri = root.right;
		return le.val == ri.val && LE101isSymmetric.isSameTree(le, ri);
    }
	public static boolean isSameTree(TreeNode p, TreeNode q) {
	    // base case
	    if(p==null || q==null) return p==null && q==null;
	    // recursion
	    return p.val==q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
	}
	public boolean isSymmetric(TreeNode root) {
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}
	public static void main(String[] args){
		String s = "[](){}";
		for(int i = 0; i < s.length(); i++){
			System.out.println(s.charAt(i)-'a');
		}
	}
}
