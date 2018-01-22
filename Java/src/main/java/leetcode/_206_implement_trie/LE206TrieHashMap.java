package leetcode._206_implement_trie;

import java.util.HashMap;
import java.util.Map;

public class LE206TrieHashMap {
    private boolean isWord;
    private Map<Character, LE206TrieHashMap> next;
    /** Initialize your data structure here. */
    public LE206TrieHashMap() {
        isWord = false;
        next = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 0) return;
        insert(this, word, 0);
    }

    private void insert(LE206TrieHashMap LE206TrieHashMap, String word, int idx) {
        if (idx == word.length()) {
            LE206TrieHashMap.isWord = true;
            return;
        }
        LE206TrieHashMap nxtLE206TrieHashMap = LE206TrieHashMap.next.get(word.charAt(idx));
        if (nxtLE206TrieHashMap == null) {
            nxtLE206TrieHashMap = new LE206TrieHashMap();
            LE206TrieHashMap.next.put(word.charAt(idx), nxtLE206TrieHashMap);
        }
        LE206TrieHashMap.insert(nxtLE206TrieHashMap, word, idx+1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 0) return true;
        LE206TrieHashMap lastLE206TrieHashMap = find(this, word, 0);
        if (lastLE206TrieHashMap == null || !lastLE206TrieHashMap.isWord) return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (find(this, prefix, 0) == null) return false;
        return true;
    }

    private LE206TrieHashMap find(LE206TrieHashMap LE206TrieHashMap, String s, int idx) {
        if (LE206TrieHashMap == null) return null;
        if (s.length() == idx) return LE206TrieHashMap;
        return find(LE206TrieHashMap.next.get(s.charAt(idx)), s, idx+1);
    }
}
