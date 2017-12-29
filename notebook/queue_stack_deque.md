# Queue vs Stack vs Deque

### Queue

[doc](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)

|        |Throws exception  |Returns special value   |
|--------|------------------|------------------------|
|Insert  |add(e)            |offer(e)                |
|Remove  |remove()          |poll()                  |
|Examine |element()         |peek()                  |

#### Usage

[source](https://www.geeksforgeeks.org/queue-interface-java/)

```java
public class QueueExample
{
  public static void main(String[] args)
  {
    Queue<Integer> q = new LinkedList<>();
 
    // Adds elements {0, 1, 2, 3, 4} to queue
    for (int i=0; i<5; i++)
     q.add(i);
 
    // Display contents of the queue.
    System.out.println("Elements of queue-"+q);
 
    // To remove the head of queue.
    int removedele = q.remove();
    System.out.println("removed element-" + removedele);
 
    System.out.println(q);
 
    // To view the head of queue
    int head = q.peek();
    System.out.println("head of queue-" + head);
 
    // Rest all methods of collection interface,
    // Like size and contains can be used with this
    // implementation.
    int size = q.size();
    System.out.println("Size of queue-" + size);
  }
}

```

### Stack

[doc](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)

|        |Throws exception  |
|--------|------------------|
|Insert  |push(e)           |
|Remove  |pop()             |
|Examine |peek()            |

#### Usage

[source](https://www.tutorialspoint.com/java/java_stack_class.htm)

```java
public class StackDemo {
   static void showpush(Stack st, int a) {
      st.push(new Integer(a));
      System.out.println("push(" + a + ")");
      System.out.println("stack: " + st);
   }

   static void showpop(Stack st) {
      System.out.print("pop -> ");
      Integer a = (Integer) st.pop();
      System.out.println(a);
      System.out.println("stack: " + st);
   }

   public static void main(String args[]) {
      Stack st = new Stack();
      System.out.println("stack: " + st);
      showpush(st, 42);
      showpush(st, 66);
      showpush(st, 99);
      showpop(st);
      showpop(st);
      showpop(st);
      try {
         showpop(st);
      } catch (EmptyStackException e) {
         System.out.println("empty stack");
      }
   }
}
```

### Deque

[doc](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)

#### Head vs Tail

|       |Head             |Head         |Tail              |Tail          |
|       |Throws exception |Special value|Throws exception  |Special value |
|-------|-----------------|-------------|------------------|--------------|
|Insert |addFirst(e)      |offerFirst(e)|addLast(e)        |offerLast(e)  |
|Remove |removeFirst()    |pollFirst()  |removeLast()      |pollLast()    |
|Examine|getFirst()       |peekFirst()  |getLast()         |peekLast()    |


#### Queue vs Deque

|Queue Method |Deque Method |
|-------------|-------------|
|add(e)       |addLast(e)   |
|offer(e)     |offerLast(e) |
|remove()     |removeFirst()|
|poll()       |pollFirst()  |
|element()    |getFirst()   |
|peek()       |peekFirst()  |

#### Stack vs Deque

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