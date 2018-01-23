package leetcode._206_implement_trie;

import java.util.HashMap;
import java.util.Map;

public class LE206TrieHashMap {
    class Trie {

        private boolean isWord;
        private Map<Character, Trie> next;
        /** Initialize your data structure here. */
        public Trie() {
            isWord = false;
            next = new HashMap<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word.length() == 0) return;
            insert(this, word, 0);
        }

        private void insert(Trie trie, String word, int idx) {
            if (idx == word.length()) {
                trie.isWord = true;
                return;
            }
            Trie nxtTrie = trie.next.get(word.charAt(idx));
            if (nxtTrie == null) {
                nxtTrie = new Trie();
                trie.next.put(word.charAt(idx), nxtTrie);
            }
            trie.insert(nxtTrie, word, idx+1);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word.length() == 0) return true;
            Trie lastTrie = find(this, word, 0);
            if (lastTrie == null || !lastTrie.isWord) return false;
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (find(this, prefix, 0) == null) return false;
            return true;
        }

        private Trie find(Trie trie, String s, int idx) {
            if (trie == null) return null;
            if (s.length() == idx) return trie;
            return find(trie.next.get(s.charAt(idx)), s, idx+1);
        }
    }
}
