package leetcode;

import utility.RandomListNode;

public class LE138copyRandomList {
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head;
        while(node != null){
            RandomListNode copy_node = new RandomListNode(node.label);
            copy_node.next = node.next;
            node.next = copy_node;
            node = copy_node.next;
        }
        node = head;
        while(node != null){
            if(node.random != null){ node.next.random = node.random.next; }
            node = node.next.next;
        }
        RandomListNode dummyhead = new RandomListNode(0);
        RandomListNode copy_node =  dummyhead;
        node = head; 
        while(node != null && node.next != null){
            copy_node.next = node.next;
            node.next = node.next.next;
            copy_node = copy_node.next;
            node = node.next;
        }
        return dummyhead.next;
    }
	
//	public RandomListNode copyRandomList(RandomListNode head) {
//	  if (head == null) return null;
//	  
//	  Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//	  
//	  // loop 1. copy all the nodes
//	  RandomListNode node = head;
//	  while (node != null) {
//	    map.put(node, new RandomListNode(node.label));
//	    node = node.next;
//	  }
//	  
//	  // loop 2. assign next and random pointers
//	  node = head;
//	  while (node != null) {
//	    map.get(node).next = map.get(node.next);
//	    map.get(node).random = map.get(node.random);
//	    node = node.next;
//	  }
//	  
//	  return map.get(head);
//	}
	
//	public RandomListNode copyRandomList(RandomListNode head) {
//		RandomListNode iter = head, next;
//
//		// First round: make copy of each node,
//		// and link them together side-by-side in a single list.
//		while (iter != null) {
//			next = iter.next;
//
//			RandomListNode copy = new RandomListNode(iter.label);
//			iter.next = copy;
//			copy.next = next;
//
//			iter = next;
//		}
//
//		// Second round: assign random pointers for the copy nodes.
//		iter = head;
//		while (iter != null) {
//			if (iter.random != null) {
//				iter.next.random = iter.random.next;
//			}
//			iter = iter.next.next;
//		}
//
//		// Third round: restore the original list, and extract the copy list.
//		iter = head;
//		RandomListNode pseudoHead = new RandomListNode(0);
//		RandomListNode copy, copyIter = pseudoHead;
//
//		while (iter != null) {
//			next = iter.next.next;
//
//			// extract the copy
//			copy = iter.next;
//			copyIter.next = copy;
//			copyIter = copy;
//
//			// restore the original list
//			iter.next = next;
//
//			iter = next;
//		}
//
//		return pseudoHead.next;
//	}

}
