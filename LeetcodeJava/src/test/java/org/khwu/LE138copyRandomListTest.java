package org.khwu;
import org.khwu.utility.RandomListNode;
import org.khwu.utility.RandomLinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LE138copyRandomListTest {
	@Test
	public void test() {
		RandomListNode a1 = new RandomListNode(1);
		RandomListNode a2 = new RandomListNode(2);
		RandomListNode a3 = new RandomListNode(3);
		RandomListNode a4 = new RandomListNode(4);
		RandomListNode a5 = new RandomListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a1.random = a3;
		a2.random = a5;
		a3.random = a4;
		a4.random = a2;
		a5.random = a4;
		LE138CopyRandomList test = new LE138CopyRandomList();
		RandomListNode result = test.copyRandomList(a1);
		assertEquals("original head", "1+3->2+5->3+4->4+2->5+4", new RandomLinkedList(a1).toString());
		assertEquals("copy head", "1+3->2+5->3+4->4+2->5+4", result.toString());
	}
}
