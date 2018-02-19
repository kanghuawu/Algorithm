package org.khwu._208_implement_trie;

public class LE208TrieTST {
    class Trie {
        private class Node {
            private char ch;
            private Node left, mid, right;
            private boolean isWord;
        }

        private Node root;

        public Trie() {}

        public void insert(String word) {
            root = insert(root, word, 0);
        }

        private Node insert(Node node, String word, int i) {
            // System.out.println(i);
            char ch = word.charAt(i);
            if (node == null) {
                node = new Node();
                node.ch = ch;
            }

            if (ch > node.ch) node.right = insert(node.right, word, i);
            else if (ch < node.ch) node.left =  insert(node.left, word, i);
            else if (word.length() - 1 == i) node.isWord = true;
            else node.mid = insert(node.mid, word, i+1);
            return node;
        }

        public boolean search(String word) {
            Node lastNode = find(root, word, 0);
            if (lastNode == null) return false;
            // System.out.println(lastNode.isWord);
            return lastNode.isWord;
        }

        /*
        public boolean search(String word) {
            return search(root, word, 0);
        }

        public boolean search(Node node, String word, int idx) {
            if (node == null || idx >= word.length()) return false;
            char ch = word.charAt(idx);
            if (ch > node.ch) return search(node.right, word, idx);
            else if (ch < node.ch) return search(node.left, word, idx);
            else if (word.length()-1 == idx && node.isWord) return true;
            return search(node.mid, word, idx+1);
        }
         */

        public boolean startsWith(String prefix) {
            Node lastNode = find(root, prefix, 0);
            return lastNode != null;
        }

        private Node find(Node node, String word, int i) {
            if (node == null) return null;
            char ch = word.charAt(i);

            if (ch > node.ch) return find(node.right, word, i);
            else if (ch < node.ch) return find(node.left, word, i);
            else if (word.length()-1 == i) return node;
            return find(node.mid, word, i+1);
        }
    }
}
