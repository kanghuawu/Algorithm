package org.khwu;

import utility.ListNode;

public class LE206ReverseList {
    // MY
//    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode end = head;
//        ListNode swap = head.next;
//        while (swap != null) {
//            end.next = swap.next;
//            swap.next = dummy.next;
//            dummy.next = swap;
//            swap = end.next;
//        }
//        return dummy.next;
//    }

    // ref: https://discuss.leetcode.com/topic/16506/my-java-recursive-solution
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
}
