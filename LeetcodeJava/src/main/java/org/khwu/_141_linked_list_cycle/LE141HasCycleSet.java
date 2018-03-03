package org.khwu._141_linked_list_cycle;

import org.khwu.utility.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LE141HasCycleSet {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}
