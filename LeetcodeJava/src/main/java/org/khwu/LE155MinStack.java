package org.khwu;
import java.util.Stack;


public class LE155MinStack {
    /** initialize your data structure here. */
    /*
    Stack<Integer> stack;
    Stack<Integer> min;

    public LE155MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek() > x){
            min.push(x);
        }else{
            min.push(min.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
    */
    long min;
    Stack<Long> stack;
    public LE155MinStack() {
        stack = new Stack<Long>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(Long.valueOf(0L));
            min = x;
        }
        else{
            stack.push(Long.valueOf(x - min));
            if(x < min)
                min = x;
        }
    }
    
    public void pop() {
        Long delta = stack.pop();
        if(delta < 0)
            min = (int) (min - delta);
        
    }
    
    public int top() {
        Long delta = stack.peek();
        if(delta > 0)
            return (int) (min + delta);
        else
            return (int) min;

    }
    
    public int getMin() {
        return (int) min;
    }

    public static void main(String arg[]){
        System.out.println(Integer.MIN_VALUE - (long)2147483647);
        // LE155MinStack minStack = new LE155MinStack();
        // minStack.push(-1);
        // System.out.println(minStack.top());
        // minStack.push(-2);
        // minStack.push(0);
        // minStack.push(-3);
        // System.out.println(minStack.getMin());
        // minStack.pop();
        // System.out.println(minStack.top());
        // System.out.println(minStack.getMin());
    }
}


