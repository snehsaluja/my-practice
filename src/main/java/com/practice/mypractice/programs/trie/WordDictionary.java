package com.practice.mypractice.programs.trie;

// Design Add and Search Words Data Structure

import java.util.LinkedList;
import java.util.Queue;

public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            curr = curr.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return search(word, 0, curr);
    }

    private boolean search(String word, int index, TrieNode curr) {
        if (curr == null) {
            return false;
        }
        if (index == word.length()) {
            return curr.endOfWord;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            boolean dotFlag = false;
            TrieNode temp = curr;
            for (char dotChar : curr.children.keySet()) {
                temp = curr.children.get(dotChar);
                dotFlag = dotFlag || search(word, index + 1, temp);
            }
            return dotFlag;
        } else if (!curr.children.containsKey(ch)) {
            return false;
        }
        curr = curr.children.get(ch);

        return search(word, index + 1, curr);
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
