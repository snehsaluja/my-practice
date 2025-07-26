package com.practice.mypractice.programs.trie;

public class LongestCommonPrefix_Trie {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        MyTrieNode[] charNodes = new MyTrieNode[26];
        for (String s : strs) {
            MyTrieNode[] children = charNodes;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (children[ch - 'a'] == null) {
                    children[ch - 'a'] = new MyTrieNode();
                } else {
                    children[ch - 'a'].freq++;
                }
                children = children[ch - 'a'].children;
            }
        }
        MyTrieNode[] children = charNodes;
        StringBuilder sb = new StringBuilder();
        int j = 0;
        outer:
        while (j++ < strs[0].length()) {
            for (int i = 0; i < 26; i++) {
                if (children[i] != null) {
                    if (children[i].freq != strs.length) {
                        break outer;
                    } else {
                        sb.append((char) ('a' + i));
                        children = children[i].children;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    static class MyTrieNode {

        MyTrieNode[] children = new MyTrieNode[26];
        int freq;

        MyTrieNode() {
            this.freq = 1;
        }
    }
}
