package org.khwu._225_implement_stack_using_queues;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {

    private Deque<Integer> q;
    /** Initialize your data structure here. */
    public MyStack() {
        this.q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Deque<Integer> tmp = new LinkedList<>();
        tmp.addLast(x);
        while (!q.isEmpty()) {
            tmp.addLast(q.removeFirst());
        }
        q = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return q.getFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
