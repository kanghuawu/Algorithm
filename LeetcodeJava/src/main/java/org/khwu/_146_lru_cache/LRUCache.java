package org.khwu._146_lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final DoubleLinkedList nodes;
    private final Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodes = new DoubleLinkedList();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        // System.out.print("bf: ");
        // nodes.printAll();
        Node node = map.get(key);
        nodes.addFirst(nodes.remove(node));
        // System.out.print("af: ");
        // nodes.printAll();
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            nodes.remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        nodes.addFirst(node);
        if (nodes.size > capacity) {
            Node last = nodes.removeLast();
            // System.out.println(key + " " + last.key + " " + last.value);
            map.remove(last.key);
        }
    }
    static class DoubleLinkedList {
        Node first;
        Node last;
        int size = 0;
        public DoubleLinkedList() {}

        public void addFirst(Node node) {
            if (size == 0) {
                last = node;
            } else {
                first.pre = node;
                node.next = first;
                node.pre = null;
            }
            first = node;
            size++;
        }

        public Node remove(Node node) {
            size--;
            if (size == 0) {
                last = null;
                first = null;
                return node;
            }
            Node preNode = node.pre;
            if (preNode == null) {
                first = first.next;
                first.pre = null;
                return node;
            }
            Node nxtNode = node.next;
            if (nxtNode == null) {
                // System.out.println(node.value + " " + node.pre.value);
                last = last.pre;
                last.next = null;
                return node;
            }
            nxtNode.pre = preNode;
            preNode.next = nxtNode;
            return node;
        }

        public Node removeLast() {
            return remove(last);
        }

        public void printAll() {
            Node tmp = first;
            while (tmp != null) {
                System.out.printf("%d ", tmp.key);
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    static class Node {
        int key;
        int value;
        Node pre = null;
        Node next = null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
}
