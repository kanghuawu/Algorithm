package org.khwu._146_lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Node head, tail;
    private Map<Integer, Node> cache;
    private int cap, size;

    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            removeNode(node);
            addNode(node);
            return;
        }
        node = new Node(key, value);
        cache.put(key, node);
        addNode(node);
        size++;
        if (size > cap) {
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
    }

    private void addNode(Node node) {
        Node next = head.next;
        next.prev = node;
        node.next = next;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
