package org.khwu._024_swap_nodes_in_pairs;

import org.khwu.utility.ListNode;

public class LE024SwapPairsRecursion {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;
        dum.next = p2;
        p2.next = p1;
        p1.next = swapPairs(p3);
        return dum.next;
    }
}
