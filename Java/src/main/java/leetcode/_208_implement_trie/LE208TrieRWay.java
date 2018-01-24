package leetcode._208_implement_trie;

public class LE208TrieRWay {
    class Trie {
        private Trie[] next;
        private final int R = 26;
        private boolean isWord;
        /** Initialize your data structure here. */
        public Trie() {
            isWord = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insert(this, word, 0);
        }

        private void insert(Trie trie, String word, int i) {
            // System.out.println(i);
            if (i == word.length()) {
                trie.isWord = true;
                return;
            }
            if (trie.next == null) {
                trie.next = new Trie[R];
            }
            Trie nxtTrie = trie.next[word.charAt(i) - 'a'];
            if (nxtTrie == null) {
                nxtTrie = new Trie();
                trie.next[word.charAt(i) - 'a'] = nxtTrie;
            }
            insert(nxtTrie, word, i + 1);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie lastTrie = find(this, word, 0);

            if (lastTrie == null) return false;
            return lastTrie.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie lastTrie = find(this, prefix, 0);
            // System.out.println(lastTrie.next == null);
            return lastTrie != null;
        }

        private Trie find(Trie trie, String word, int i) {
            // System.out.println(i);
            if (word.length() == i) return trie;
            if (trie == null || trie.next == null) return null;
            return find(trie.next[word.charAt(i) - 'a'], word, i+1);
        }
    }
}
