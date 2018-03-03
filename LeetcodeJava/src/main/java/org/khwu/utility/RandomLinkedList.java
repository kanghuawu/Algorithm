package org.khwu.utility;

public class RandomLinkedList {
	
	private RandomListNode head;
	
	public RandomLinkedList(RandomListNode node){
		this.head = node;
	}
	
	public String toString(){
		StringBuilder re = new StringBuilder();
		RandomListNode node = head;
		while(node != null){
			re.append(node.toString());
			re.append("->");
			node = node.next;
		}
		if(re.length() > 2) { re.setLength(re.length() - 2); }
		return re.toString();
	}
}
