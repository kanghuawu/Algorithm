package org.khwu._642_design_search_autocomplete_system;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AutocompleteSystem {
    private Trie trie;
    private StringBuilder input;
    private Node lastNode;
    private boolean firstChar;
    private PriorityQueue<WordNode> pq;

    public AutocompleteSystem(String[] sentences, int[] times) {
        input = new StringBuilder();
        trie = new Trie();
        firstChar = true;
        for (int i = 0; i < sentences.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
        pq = new PriorityQueue<>(3, (wn1, wn2) -> {
            if (wn1.times == wn2.times) return wn2.s.compareTo(wn1.s);
            return wn1.times - wn2.times;
        });
    }

    public List<String> input(char c) {
        if (c == '#') {
            String latest = input.toString();
            // System.out.println(latest);
            // if (lastNode == null) System.out.println("lastNode is null");
            // else System.out.println(lastNode.ch + " " + lastNode.times);
            if (lastNode == null) trie.insert(latest, 1);
            else lastNode.times++;
            input = new StringBuilder();
            lastNode = null;
            firstChar = true;
            return new LinkedList<>();
        }
        pq.clear();
        input.append(c);
        if (lastNode == null && firstChar) lastNode = trie.find(trie.root, c);
        else if (lastNode != null) lastNode = trie.find(lastNode.mid, c);

        if (lastNode != null) {
            if (lastNode.times != 0) pq.add(new WordNode(input.toString(), lastNode.times));
            // System.out.println(lastNode.ch);
            trie.collect(lastNode.mid, new StringBuilder(input), pq);
        }

        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.addFirst(pq.poll().s);
        }
        firstChar = false;
        return res;
    }

    class WordNode {
        String s;
        int times;
        public WordNode(String s, int times) {
            this.s = s;
            this.times = times;
        }
    }

    class Node {
        private char ch;
        private Node left, mid, right;
        private int times;
    }

    class Trie {
        private Node root;

        public Node find(Node node, char ch) {
            if (node == null) return null;
            if (ch > node.ch) return find(node.right, ch);
            else if (ch < node.ch) return find(node.left, ch);
            else if (ch == node.ch) return node;
            return null;
        }

        public void collect(Node node, StringBuilder sb, PriorityQueue<WordNode> pq) {
            if (node == null) return;
            collect(node.left, sb, pq);
            collect(node.right, sb, pq);
            sb.append(node.ch);
            if (node.times != 0) {
                // System.out.println(node.ch +" "+ sb.toString());
                pq.add(new WordNode(sb.toString(), node.times));
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
            collect(node.mid, sb, pq);
            sb.deleteCharAt(sb.length() - 1);
        }

        public void insert(String word, int times) {
            root = insert(root, word, 0, times);
        }

        private Node insert(Node node, String word, int i, int times) {
            char ch = word.charAt(i);
            if (node == null) {
                node = new Node();
                node.ch = ch;
                node.times = 0;
            }

            if (ch > node.ch) node.right = insert(node.right, word, i, times);
            else if (ch < node.ch) node.left =  insert(node.left, word, i, times);
            else if (word.length() - 1 == i) node.times = times;
            else node.mid = insert(node.mid, word, i+1, times);
            return node;
        }
    }
}