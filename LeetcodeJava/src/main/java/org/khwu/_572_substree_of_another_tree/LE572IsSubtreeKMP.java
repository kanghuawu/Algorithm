package org.khwu._572_substree_of_another_tree;

import org.khwu.utility.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LE572IsSubtreeKMP {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String ss = buildTree(s, new StringBuilder());
        String st = buildTree(t, new StringBuilder());
        return ss.indexOf(st) != -1;
    }

    private String buildTree(TreeNode node, StringBuilder sb) {
        Deque<TreeNode> st = new LinkedList<>();
        st.addLast(node);
        while (!st.isEmpty()) {
            TreeNode tmp = st.removeLast();
            if (tmp == null) {
                sb.append("#");
            } else {
                sb.append(",");
                sb.append(tmp.val);
                st.addLast(tmp.left);
                st.addLast(tmp.right);
            }
        }

        return sb.toString();
    }
}
