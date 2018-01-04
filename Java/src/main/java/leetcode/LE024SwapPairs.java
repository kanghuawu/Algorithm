package leetcode;

import utility.ListNode;

public class LE024SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode node = dummyhead;
        while (node.next != null && node.next.next != null) {
            ListNode end = node.next.next.next;
            ListNode first = node.next;
            node.next = first.next;
            node.next.next = first;
            first.next = end;
            node = first;
        }
        return dummyhead.next;
    }
}
