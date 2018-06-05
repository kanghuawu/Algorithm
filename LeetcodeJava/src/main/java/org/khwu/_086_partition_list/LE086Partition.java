package org.khwu._086_partition_list;

import org.khwu.utility.ListNode;

public class LE086Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyS = new ListNode(0);
        ListNode nodeS = dummyS;
        ListNode dummyB = new ListNode(0);
        ListNode nodeB = dummyB;
        while (head != null) {
            if (head.val < x) {
                nodeS.next = head;
                nodeS = nodeS.next;
            } else {
                nodeB.next = head;
                nodeB = nodeB.next;
            }
            head = head.next;
        }
        nodeB.next = null;
        nodeS.next = dummyB.next;
        return dummyS.next;
    }
}
