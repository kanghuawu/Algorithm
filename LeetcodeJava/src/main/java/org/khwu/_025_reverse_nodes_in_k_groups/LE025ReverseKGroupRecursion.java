package org.khwu._025_reverse_nodes_in_k_groups;

import org.khwu.utility.ListNode;

public class LE025ReverseKGroupRecursion {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode pt1 = head;
        int c = 0;
        while (pt1 != null && c < k) {
            c++;
            pt1 = pt1.next;
        }

        if (c != k) return head;

        pt1 = reverseKGroup(pt1, k);

        while (c-- > 0) {
            ListNode tmp = head.next;
            head.next = pt1;
            pt1 = head;
            head = tmp;
        }

        return pt1;
    }
}
