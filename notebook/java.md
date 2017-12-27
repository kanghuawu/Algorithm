
### Cheatsheet


### Queue

[doc](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)

|        |Throws exception  |Returns special value   |
|--------|------------------|------------------------|
|Insert  |add(e)            |offer(e)                |
|Remove  |remove()          |poll()                  |
|Examine |element()         |peek()                  |

### Stack

[doc](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)

|        |Throws exception  |
|--------|------------------|
|Insert  |push(e)           |
|Remove  |pop()             |
|Examine |peek()            |

### Deque

[doc](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)

|       |First Element (Head)           |Last Element (Tail)               |
|       |:-----------------------------:|:--------------------------------:|
|       |Throws exception |Special value|Throws exception  |Special value  |
|-------|-----------------|-------------|------------------|---------------|
|Insert |addFirst(e)      |offerFirst(e)|addLast(e)        |offerLast(e)   |
|Remove |removeFirst()    |pollFirst()  |removeLast()      |pollLast()     |
|Examine|getFirst()       |peekFirst()  |getLast()         |peekLast()     |


|Queue Method |Deque Method |
|-------------|-------------|
|add(e)       |addLast(e)   |
|offer(e)     |offerLast(e) |
|remove()     |removeFirst()|
|poll()       |pollFirst()  |
|element()    |getFirst()   |
|peek()       |peekFirst()  |

|Stack Method  |Deque Method  |
|--------------|--------------|
|push(e)       |addFirst(e)   |
|pop()         |removeFirst() |
|peek()        |peekFirst()   |

#### Usage

```java
public class DequeAndArrayDeque {
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