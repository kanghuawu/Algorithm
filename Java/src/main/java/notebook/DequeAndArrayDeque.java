package notebook;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeAndArrayDeque {
	// Deque Usage
	// https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
	
	// ArrayDeque as stack
	// Deque<String> stack = new ArrayDeque<String>();
	// stack.push("a");
	// stack.pop()
	
	// ArrayDeque as queue
	// Deque<String> queue = new ArrayDeque<String>();
	// queue.add("b");
	// queue.poll();
	public static void main(String[] args){
		Deque<Integer> stack = new ArrayDeque<Integer>();
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		System.out.println("Stack: ");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("Queue: ");
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
