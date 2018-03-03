package org.khwu;

import org.khwu.utility.ListNode;

public class LE147InsertionSortList {
    
    public ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
//				System.out.print(pre.val);
				pre = pre.next;
//				System.out.println(" " + pre.val);
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
			printNode(helper);
			System.out.println();
		}
		
		return helper.next;
	}
    
    public static void printNode(ListNode head){
    	while(head != null){
    		if(head.next == null){
    			System.out.print(head.val);
    			head = head.next;
    		}else{
    			System.out.print(head.val + "->");
        		head = head.next;
    		}
    	}
    }
    
	public static void main(String[] args){
		ListNode L1 = new ListNode(4);
		ListNode L2 = new ListNode(2);
		ListNode L3 = new ListNode(3);
		ListNode L4 = new ListNode(1);
		L1.next = L2;
		L2.next = L3;
		L3.next = L4;
//		printNode(L1);
		System.out.println();
		LE147InsertionSortList test = new LE147InsertionSortList();
		printNode(test.insertionSortList(L1));
	}
}
