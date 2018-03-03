package org.khwu;
import org.khwu.utility.ListNode;

public class LE002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head = new ListNode(0);
    	ListNode re = head;
    	int val;
    	boolean inc = false;
    	while(l1 != null || l2 != null || inc){
    		val = inc ? 1 : 0; 
    		if(l1 != null){
    			val += l1.val;
    			l1 = l1.next;
    		}
    		if(l2 != null) {
    			val += l2.val;
    			l2 = l2.next;
    		}
    		inc = val >= 10 ? true : false;
    		re.next = new ListNode(val % 10);
//    		System.out.println(re.val);
    		re = re.next;
    	}
    	re = null;
    	return head.next;
    }
//    public ListNode helpAddNode(ListNode l1, ListNode l2, boolean inc){
//    	ListNode re;
//    	int val = inc ? 1 : 0; 
//		if(l1 != null) val += l1.val;
//		if(l2 != null) val += l2.val;
//		re = new ListNode(val);
//    	}else{
//    		if(l1 == null && l2 == null) re = null;
//    		else if(l1 == null) re = l2.next;
//        	else if(l2 == null) re = l1.next;
//        	else{
//        		re = new ListNode((l1.val + l2.val) % 10);
//        		if (l1.val + l2.val >=10) re.next = helpAddNode(l1.next, l2.next, true);
//        		else re.next = helpAddNode(l1.next, l2.next, false);
//        	}
//    	}
//    	return re;
//    }
    
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
		LE002AddTwoNumbers test = new LE002AddTwoNumbers();
		ListNode tt = test.addTwoNumbers(L1, L4);
		while(tt != null){
			System.out.print(tt.val + " ");
			tt = tt.next;
		}
		
    }
}
