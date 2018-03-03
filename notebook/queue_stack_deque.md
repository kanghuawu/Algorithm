# Queue vs Stack vs Deque

## Table of Content

* [tldr](#tldr)
* [Queue](#queue)
* [Stack](#stack)
* [Deque](#deque)

## tldr

### Queue vs Deque

|Queue Method |Deque Method |
|-------------|-------------|
|offer(e)     |offerLast(e) |
|poll()       |pollFirst()  |
|peek()       |peekFirst()  |

### Stack vs Deque

|Stack Method  |Deque Method  |
|--------------|--------------|
|push(e)       |addFirst(e)   |
|pop()         |removeFirst() |
|peek()        |peekFirst()   |

## Queue
* [Oracle doc](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)

|        |Throws exception  |Returns special value   |
|--------|------------------|------------------------|
|Insert  |add(e)            |offer(e)                |
|Remove  |remove()          |poll()                  |
|Examine |element()         |peek()                  |

### Usage

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

## Stack
* [Oracle doc](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)

|        |Throws exception  |
|--------|------------------|
|Insert  |push(e)           |
|Remove  |pop()             |
|Examine |peek()            |

### Usage

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
## Deque
* [Oracle doc](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)

### Head vs Tail

|Head   |Throws exception |Special value|
|-------|-----------------|-------------|
|Insert |addFirst(e)      |offerFirst(e)|
|Remove |removeFirst()    |pollFirst()  |
|Examine|getFirst()       |peekFirst()  |

|Tail   |Throws exception  |Special value |
|-------|------------------|--------------|
|Insert |addLast(e)        |offerLast(e)  |
|Remove |removeLast()      |pollLast()    |
|Examine|getLast()         |peekLast()    |

### Usage

#### Code
```java
public class DequeAndArrayDeque {
  public static void main(String[] args) {
        System.out.println("=== Stack ===");
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.printf("%s%d%n", StringUtils.rightPad("Peek: ", 15), stack.peek());
        System.out.printf("%s%d%n", StringUtils.rightPad("PeekFirst: ", 15), stack.peekFirst());
        System.out.printf("%s%d%n", StringUtils.rightPad("Poll: ", 15), stack.poll());
        System.out.printf("%s%d%n", StringUtils.rightPad("PollFirst: ", 15), stack.pollFirst());
        System.out.printf("%s%d%n", StringUtils.rightPad("Remove: ", 15), stack.removeFirst());
        System.out.printf("%s%d%n", StringUtils.rightPad("Add:", 15), 6);
        stack.addFirst(6);
        System.out.printf("%s%d%n", StringUtils.rightPad("Remove: ", 15), stack.pop());

        System.out.println("=== Queue ===");
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            queue.addLast(i);
        }
        System.out.printf("%s%d%n", StringUtils.rightPad("Peek: ", 15), queue.peek());
        System.out.printf("%s%d%n", StringUtils.rightPad("PeekFirst: ", 15), queue.peekFirst());
        System.out.printf("%s%d%n", StringUtils.rightPad("PeekLast: ", 15), queue.peekLast());
        System.out.printf("%s%d%n", StringUtils.rightPad("Poll: ", 15), queue.poll());
        System.out.printf("%s%d%n", StringUtils.rightPad("PollFirst: ", 15), queue.pollFirst());
        System.out.printf("%s%d%n", StringUtils.rightPad("PollLast: ", 15), queue.pollLast());
        System.out.printf("%s%d%n", StringUtils.rightPad("Remove: ", 15), queue.remove());
        System.out.printf("%s%d%n", StringUtils.rightPad("Add:", 15), 6);
        queue.add(6);
        System.out.printf("%s%d%n", StringUtils.rightPad("Remove: ", 15), queue.remove());
    }
}
```

#### Result

```shell
=== Stack ===
Peek:          5
PeekFirst:     5
Poll:          5
PollFirst:     4
Remove:        3
Add:           6
Remove:        6
=== Queue ===
Peek:          1
PeekFirst:     1
PeekLast:      5
Poll:          1
PollFirst:     2
PollLast:      5
Remove:        3
Add:           6
Remove:        4
```
