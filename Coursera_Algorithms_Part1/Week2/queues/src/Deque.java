import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

    private int size = 0;
    private Node first = null;
    private Node last = null;

    private class Node {
        private Item item = null;
        private Node previous = null;
        private Node next = null;
        public Node(Item item) {
            this.item = item;
        }
    }

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }
    
    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) 
            throw new IllegalArgumentException("item can not be null");
        if (size == 0) {
            first = new Node(item);
            last = first;
        } else {
            Node temp = first;
            first = new Node(item);
            temp.previous = first;
            first.next = temp;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) 
            throw new IllegalArgumentException("item can not be null");
        if (size == 0) {
            last = new Node(item);
            first = last;
        } else {
            Node temp = last;
            last = new Node(item);
            temp.next = last;
            last.previous = temp;
        }
        size++;
    }
    
    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) 
            throw new NoSuchElementException("deque is empty");
        Node temp = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = temp.next;
        }
        size--;
        return temp.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (size == 0) 
            throw new NoSuchElementException("deque is empty");
        Node temp = last;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = temp.previous;
        }
        size--;
        return temp.item;
    }

    private class DequeIterator implements Iterator<Item> {
        
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (current == null)
                throw new NoSuchElementException("iterator is empty");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    // unit testing (optional)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        StdOut.println(deque.isEmpty());
        deque.addFirst("1");
        deque.addFirst("3");
        deque.addFirst("5");
        deque.addFirst("7");
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.size());
        deque.addLast("2");
        deque.addLast("4");
        deque.addLast("6");
        for (String s : deque) {
            StdOut.print(s + " ");
        }
        StdOut.println();
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.size());
        // StdOut.println(deque.removeFirst());
        // StdOut.println(deque.removeLast());
        // StdOut.println(deque.removeFirst());
        for (String s : deque) {
            StdOut.print(s + " ");
        }
        StdOut.println();

        Iterator<String> it = deque.iterator();
        while (it.hasNext()) {
            String s = it.next();
            StdOut.print(s + " ");
        }
        // it.remove();
        // it.next();
        StdOut.println();
    }
}
