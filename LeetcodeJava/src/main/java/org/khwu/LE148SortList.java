package org.khwu;

import org.khwu.utility.ListNode;

public class LE148SortList {
    public ListNode sortList(ListNode head) {
        
    	return head;
    }
    public static void printNode(ListNode head){
    	while(head != null){
    		System.out.print(head.val + "->");
    		head = head.next;
    	}
    }
    
	public static void main(String[] args){
		ListNode L1 = new ListNode(2);
		ListNode L2 = new ListNode(4);
		ListNode L3 = new ListNode(3);
		ListNode L4 = new ListNode(5);
		ListNode L5 = new ListNode(6);
		ListNode L6 = new ListNode(7);
		L1.next = L2;
		L2.next = L3;
		L4.next = L5;
		L5.next = L6;
		printNode(L1);
		System.out.println();
		LE148SortList test = new LE148SortList();
		printNode(test.sortList(L1));
	}
}
