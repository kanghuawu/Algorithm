package org.khwu._160_intersection_of_two_linked_lists;

import org.khwu.utility.ListNode;

public class LE160GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lA = len(headA);
        int lB = len(headB);
        ListNode shortter = lA > lB ? headB : headA;
        ListNode longer = lA > lB ? headA : headB;
        int diff = Math.abs(lA - lB);
        while (diff != 0) {
            longer = longer.next;
            diff--;
        }
        while (longer != null && longer != shortter) {
            longer = longer.next;
            shortter = shortter.next;
        }
        return longer;
    }

    private int len(ListNode node) {
        int res = 0;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }
}
