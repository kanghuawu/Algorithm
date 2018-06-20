package org.khwu._117_populating_next_right_pointers_in_each_node_ii;

import org.khwu.utility.TreeLinkNode;

public class LE117ConnectRecursion {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curr = root;
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode nxt = dummy;
        while (curr != null) {
            if (curr.left != null) {
                nxt.next = curr.left;
                nxt = nxt.next;
            }
            if (curr.right != null) {
                nxt.next = curr.right;
                nxt = nxt.next;
            }
            curr = curr.next;
        }
        connect(dummy.next);
    }
}
