package leetcode;

public class LE019RemoveNthFromEnd {
    // My
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pt1 = head;
        ListNode pt2 = dummy;
        for (int i = 0; i < n; i++) {
            pt1 = pt1.next;
        }
        // if (pt1 == null) return null;
        while (pt1 != null) {
            pt1 = pt1.next;
            pt2 = pt2.next;
        }

        pt2.next = pt2.next.next;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
