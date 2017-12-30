package leetcode;
import org.khwu.utility.TreeNode;

public class LE100IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
	    // base case
	    if(p==null || q==null) return p==null && q==null;
	    // recursion
	    return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
    public static void main(String[] args){
    	TreeNode tr1_1 = new TreeNode(23);
    	TreeNode tr1_2 = new TreeNode(15);
    	TreeNode tr1_3 = new TreeNode(34);
    	TreeNode tr1_4 = new TreeNode(20);
    	TreeNode tr1_5 = new TreeNode(1);
    	TreeNode tr1_6 = new TreeNode(19);
    	tr1_1.left = tr1_2;
    	tr1_1.right = tr1_3;
    	tr1_2.left = tr1_3;
    	tr1_2.right = tr1_4;
    	tr1_3.left = tr1_5;
    	tr1_3.right = tr1_6;
    	TreeNode tr2_1 = new TreeNode(23);
    	TreeNode tr2_2 = new TreeNode(15);
    	TreeNode tr2_3 = new TreeNode(34);
    	TreeNode tr2_4 = new TreeNode(20);
    	TreeNode tr2_5 = new TreeNode(1);
    	TreeNode tr2_6 = new TreeNode(19);
    	tr2_1.left = tr2_2;
    	tr2_1.right = tr2_3;
    	tr2_2.left = tr2_3;
    	tr2_2.right = tr2_4;
    	tr2_3.left = tr2_5;
    	tr2_3.right = tr2_6;
    	LE100IsSameTree tree = new LE100IsSameTree();
    	System.out.println(tree.isSameTree(tr1_1, tr2_1));
    }
}
