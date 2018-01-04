package leetcode;

import utility.ListNode;

public class LE092ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        //if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode oriFirst = dummy;
        ListNode oriSecond = head;

        ListNode subFirst = new ListNode(0);
        ListNode subSecond = head;

        ListNode temp;

        int idx = 1;

        while (idx <= n) {

            if (idx == m) {
                subFirst.next = oriFirst.next;
                subSecond = oriFirst.next;
                oriSecond = oriFirst.next.next;
            } else if (idx < m) {
                oriFirst = oriFirst.next;
            } else {
                temp = subFirst.next;
                subFirst.next = oriSecond;
                oriSecond = oriSecond.next;
                subFirst.next.next = temp;
            }
            idx++;
        }
        oriFirst.next = subFirst.next;
        subSecond.next = oriSecond;
        return dummy.next;
    }
}
