package org.khwu._232_implement_queue_using_stacks;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

    private Deque<Integer> s1;
    private Deque<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        helper();
        return s2.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        helper();
        return s2.getLast();
    }

    private void helper() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.addLast(s1.removeLast());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
