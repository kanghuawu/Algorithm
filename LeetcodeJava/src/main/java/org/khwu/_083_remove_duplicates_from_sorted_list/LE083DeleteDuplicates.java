package org.khwu._083_remove_duplicates_from_sorted_list;

import org.khwu.utility.ListNode;

public class LE083DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pt1 = head;
        ListNode pt2 = head;
        while (pt2 != null) {
            while (pt2 != null && pt1.val == pt2.val) {
                pt2 = pt2.next;
            }
            pt1.next = pt2;
            pt1 = pt2;
        }
        return dummy.next;
    }
}
