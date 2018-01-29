package leetcode._676_implement_magic_dictionary;

public class LE676MagicDictionary {
    class MagicDictionary {
        private final Trie trie;

        public MagicDictionary() {
            trie = new Trie();
        }

        public void buildDict(String[] dict) {
            for (String s : dict) {
                trie.insert(s);
            }
        }

        public boolean search(String word) {
            return trie.search(word);
        }

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
                for (int i = 0; i < word.length(); i++) {
                    if (search(root, word, 0, i)) return true;
                }
                return false;
            }

            public boolean search(Node node, String word, int idx, int wrongIdx) {
                if (node == null || idx >= word.length()) return false;
                char ch = word.charAt(idx);
                if (wrongIdx == idx) {
                    if (ch == node.ch) return search(node.right, word, idx, wrongIdx) || search(node.left, word, idx, wrongIdx);
                    else if (idx == word.length() - 1 && node.isWord) return true;
                    else return search(node.mid, word, idx+1, wrongIdx);
                }
                if (ch > node.ch) return search(node.right, word, idx, wrongIdx);
                else if (ch < node.ch) return search(node.left, word, idx, wrongIdx);
                else if (word.length()-1 == idx && node.isWord) return true;
                return search(node.mid, word, idx+1, wrongIdx);
            }
        }
    }
}
