package org.khwu._116_populating_next_right_pointers_in_each_node;

import org.khwu.utility.TreeLinkNode;

public class LE116ConnectIteration {
    public void connect(TreeLinkNode root) {
        TreeLinkNode prev = root;
        while (prev != null) {
            TreeLinkNode curr = new TreeLinkNode(0);
            TreeLinkNode dummy = curr;
            while (prev != null) {
                if (prev.left != null) {
                    curr.next = prev.left;
                    curr = curr.next;
                }
                if (prev.right != null) {
                    curr.next = prev.right;
                    curr = curr.next;
                }
                prev = prev.next;
            }
            prev = dummy.next;
        }
    }
}
