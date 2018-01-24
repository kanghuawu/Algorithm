package leetcode._648_replace_words;

import java.util.List;

public class LE648ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence.length() == 0) return "";
        Trie trie = new Trie();
        for (int i = 0; i < dict.size(); i++) {
            trie.insert(dict.get(i));
        }
        StringBuilder sb = new StringBuilder();
        for (String s : sentence.split("\\s+")) {
            StringBuilder tmp = trie.search(s, new StringBuilder());
            if (tmp == null) sb.append(s);
            else sb.append(tmp);
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    static class Trie {
        private Node root;

        class Node {
            private char ch;
            private Node left, mid, right;
            private boolean isWord;
        }
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

        public StringBuilder search(String word, StringBuilder sb) {
            Node lastNode = find(root, word, 0, sb);
            if (lastNode == null || !lastNode.isWord) return null;
            return sb;
        }

        private Node find(Node node, String word, int i, StringBuilder sb) {
            if (node == null) return null;
            char ch = word.charAt(i);
            if (ch > node.ch) return find(node.right, word, i, sb);
            else if (ch < node.ch) return find(node.left, word, i, sb);
            sb.append(ch);
            if (word.length()-1 == i || node.isWord) return node;
            return find(node.mid, word, i+1, sb);
        }
    }
}
