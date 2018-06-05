package org.khwu._082_remove_duplicates_from_sorted_list_ii;

import org.khwu.utility.ListNode;

public class LE082DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
