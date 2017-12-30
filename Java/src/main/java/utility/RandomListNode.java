package org.khwu.utility;

public class RandomListNode {
	public int label;
	public RandomListNode next, random;
	public RandomListNode(int x) { this.label = x; }

	public String toString() {
		return String.valueOf(this.label) + "+" + String.valueOf(this.random.label);
	}
	
}
