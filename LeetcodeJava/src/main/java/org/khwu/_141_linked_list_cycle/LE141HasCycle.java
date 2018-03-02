package org.khwu._141_linked_list_cycle;

import utility.ListNode;

public class LE141HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode dum1 = head;
        ListNode dum2 = head;
        while (dum2.next != null && dum2.next.next != null) {
            dum1 = dum1.next;
            dum2 = dum2.next.next;
            if (dum1 == dum2) return true;
        }
        return false;
    }
}
