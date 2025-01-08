package com.practice.mypractice.programs.trie.lowercaseonly;

public class Trie_LowerCase {

    TrieNode_LowerCase root;

    public Trie_LowerCase() {
        root = new TrieNode_LowerCase();
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }
}
