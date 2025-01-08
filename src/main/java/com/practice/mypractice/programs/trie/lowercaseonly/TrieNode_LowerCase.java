package com.practice.mypractice.programs.trie.lowercaseonly;

public class TrieNode_LowerCase {

    TrieNode_LowerCase[] children;
    boolean endOfWord;

    TrieNode_LowerCase() {
        children = new TrieNode_LowerCase[26];
    }

    public void insert(String word, int index) {
        if (index >= word.length())
            return;
        int i = word.charAt(index) - 'a';
        if (children[i] == null) {
            children[i] = new TrieNode_LowerCase();
        }
        if (index == word.length() - 1) {
            children[i].endOfWord = true;
        }
        children[i].insert(word, index + 1);
    }

    public boolean search(String word, int index) {
        if (index >= word.length())
            return false;
        int i = word.charAt(index) - 'a';
        TrieNode_LowerCase node = children[i];
        if (node == null) {
            return false;
        }
        if (index == word.length() - 1) {
            return node.endOfWord;
        }
        return children[i].search(word, index + 1);
    }

    public boolean startsWith(String prefix, int index) {
        if (index >= prefix.length())
            return false;
        int i = prefix.charAt(index) - 'a';
        TrieNode_LowerCase node = children[i];
        if (node == null) {
            return false;
        }
        if (index == prefix.length() - 1) {
            return true;
        }
        return children[i].startsWith(prefix, index + 1);
    }
}
