package org.khwu._024_swap_nodes_in_pairs;

import org.khwu.utility.ListNode;

public class LE024SwapPairsIteration {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode node = dum;
        while (node.next != null && node.next.next != null) {
            ListNode p1 = node.next;
            ListNode p2 = node.next.next;
            p1.next = p2.next;
            p2.next = p1;
            node.next = p2;
            node = p1;
        }
        return dum.next;
    }

    // Original
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode node = dum;
        while (node != null && node.next != null && node.next.next != null) {
            ListNode p0 = node;
            ListNode p1 = node.next;
            ListNode p2 = node.next.next;
            ListNode p3 = node.next.next.next;
            p0.next = p2;
            p2.next = p1;
            p1.next = p3;
            node = p1;
        }
        return dum.next;
    }
}
