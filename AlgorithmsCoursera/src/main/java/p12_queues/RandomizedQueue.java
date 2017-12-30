package p12_queues;

import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int currentIndex = 0;
    private Item[] queue;

    // construct an empty randomized queue
    public RandomizedQueue() { 
        queue = (Item[]) new Object[1];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    // return the number of items on the queue
    public int size() {
        return currentIndex;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) 
            throw new IllegalArgumentException("item can not be null");
        if (queue.length == currentIndex)
            resize(queue.length * 2);
        queue[currentIndex++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (currentIndex == 0) 
            throw new NoSuchElementException("deque is empty");

        switchIndex(randomIndex(), --currentIndex);
        Item item = queue[currentIndex];
        if (currentIndex > 0 && queue.length / 4 == currentIndex)
            resize(queue.length * 2);
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (currentIndex == 0)
            throw new NoSuchElementException("deque is empty");

        return queue[randomIndex()];
    }
    
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < currentIndex; i++)
            copy[i] = queue[i];
        queue = copy;
    }

    private int randomIndex() {
        return StdRandom.uniform(currentIndex);
    }

    private void switchIndex(int i, int j) {
        if (i == j) return;
        Item temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] cpQue;
        private int cpQueIndex = 0;
        public RandomizedQueueIterator() {
            cpQue = (Item[]) new Object[currentIndex];
            for (int i = 0; i < currentIndex; i++) {
                cpQue[i] = queue[i];
            }
            StdRandom.shuffle(cpQue);
        }

        public boolean hasNext() {
            return cpQueIndex < currentIndex;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (cpQueIndex > cpQue.length)
                throw new NoSuchElementException("Index out of bound");
            return cpQue[cpQueIndex++];
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // unit testing (optional)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        rq.enqueue("5");
        rq.enqueue("6");
        rq.enqueue("7");
        rq.enqueue("8");
        rq.enqueue("9");
        rq.enqueue("10");
        StdOut.println("Sampling...");
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println("Dequeue...");
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println("Iterator...");
        for (String s : rq) 
            StdOut.println(s);
        

    }
}
