
### Cheatsheet

```

```

### Deque

[doc](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)

```java
public class DequeAndArrayDeque {
    // Deque Usage
    
    // ArrayDeque as stack
    // Deque<String> stack = new ArrayDeque<String>();
    // stack.push("a");
    // stack.pop()
    
    // ArrayDeque as queue
    // Deque<String> queue = new LinkedList<String>();
    // queue.add("b");
    // queue.remove()();
    public static void main(String[] args){
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        System.out.println("Stack: ");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        
        Deque<Integer> queue = new LinkedList<Integer>();

        System.out.println("Queue: ");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("peek: " + queue.peek());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
    }
}
```