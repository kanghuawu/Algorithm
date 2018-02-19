package org.khwu._023_merge_k_sorted_lists;

import utility.ListNode;

public class LE023MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length-1);
    }

    private ListNode split(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        } else if (lo < hi) {
            int split = lo + (hi - lo)/2;
            ListNode li1 = split(lists, lo, split);
            ListNode li2 = split(lists, split+1, hi);
            return merge(li1, li2);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode li1, ListNode li2) {
        if (li1 == null && li2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = new ListNode(0);
        dummy.next = node ;
        while (li1 != null || li2 != null) {
            if (li1 == null) {
                node.val = li2.val;
                li2 = li2.next;
            } else if (li2 == null) {
                node.val = li1.val;
                li1 = li1.next;
            } else if (li1.val > li2.val) {
                node.val = li2.val;
                li2 = li2.next;
            } else {
                node.val = li1.val;
                li1 = li1.next;
            }
            if (li1 != null || li2 != null) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }
        return dummy.next;
    }
}
