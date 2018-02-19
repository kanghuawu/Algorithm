package org.khwu;
import utility.TreeNode;

public class LE298LongestConsecutive {
    // MY
    private int maxLen;
    public int longestConsecutive(TreeNode root) {
        maxLen = 0;
        if (root == null)
            return maxLen;
        longestConsecutiveHelper(root, root.val, 1);
        return maxLen;

    }
    private void longestConsecutiveHelper(TreeNode root, int expect, int curLen) {
        if (root == null) return;
        if (root.val == expect) {
            if (curLen > maxLen)
                maxLen = curLen;
            longestConsecutiveHelper(root.left, root.val + 1, curLen + 1);
            longestConsecutiveHelper(root.right, root.val + 1, curLen + 1);
        } else {
            longestConsecutiveHelper(root.left, root.val + 1, 2);
            longestConsecutiveHelper(root.right, root.val + 1, 2);
        }
    }

    // DRY
//    private int max = 0;
//    public int longestConsecutive(TreeNode root) {
//        if(root == null) return 0;
//        helper(root, 0, root.val);
//        return max;
//    }
//
//    public void helper(TreeNode root, int cur, int target){
//        if(root == null) return;
//        if(root.val == target) cur++;
//        else cur = 1;
//        max = Math.max(cur, max);
//        helper(root.left, cur, root.val + 1);
//        helper(root.right, cur, root.val + 1);
//    }
}
