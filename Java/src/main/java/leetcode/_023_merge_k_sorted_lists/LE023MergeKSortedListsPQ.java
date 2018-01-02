package leetcode._023_merge_k_sorted_lists;

import utility.ListNode;

import java.util.PriorityQueue;

public class LE023MergeKSortedListsPQ {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (ListNode n1, ListNode n2) -> n1.val - n2.val);

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}
