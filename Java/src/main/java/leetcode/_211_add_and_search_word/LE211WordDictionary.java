package leetcode._211_add_and_search_word;

public class LE211WordDictionary {
    class WordDictionary {

        private class Node {
            private char ch;
            private Node left, mid, right;
            private boolean isWord;
        }

        private Node root;
        /** Initialize your data structure here. */
        public WordDictionary() {

        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word.length() == 0) return;
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

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            if (word.length() == 0) return true;;
            Node lastNode = find(root, word, 0);
            return lastNode != null ? lastNode.isWord : false;
        }

        private Node find(Node node, String word, int i) {
            if (node == null || i >= word.length()) return null;
            char ch = word.charAt(i);
            // System.out.println(node.ch);
            if (ch == '.'){
                if (word.length()-1 == i && node.isWord) return node;
                Node mid = find(node.mid, word, i+1);
                if (mid != null) return mid;
                Node left = find(node.left, word, i);
                if (left != null) return left;
                Node right = find(node.right, word, i);
                if (right != null) return right;
                return null;
            }
            if (ch > node.ch) return find(node.right, word, i);
            else if (ch < node.ch) return find(node.left, word, i);
            else if (word.length()-1 > i) return find(node.mid, word, i+1);
            else if (node.isWord) return node;
            return null;
        }
    }
}
