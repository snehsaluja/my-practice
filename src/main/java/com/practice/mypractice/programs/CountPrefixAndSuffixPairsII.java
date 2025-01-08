package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class CountPrefixAndSuffixPairsII {

    //Hard Problem

    public long countPrefixSuffixPairs(String[] words) {
        long res = 0;
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode x = root;
            for (int i = 0, n = word.length(); i < n; i++) {
                int key = (128 * word.charAt(i) + word.charAt(word.length() - i - 1));
                x = x.children.computeIfAbsent(key, k -> new TrieNode());
                res += x.count;
            }
            x.count++;
        }
        return res;
    }

    class TrieNode {
        Map<Integer, TrieNode> children = new HashMap<>();
        int count = 0;
    }


    // Below Solution is O(n^2), but Leetcode time wise, its most efficient.
    public long countPrefixSuffixPairs_TimeOpt(String[] words) {
        int n = words.length;
        long count = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            long found = 1;
            if (vis[i]) {
                continue;
            }
            String s = words[i];
            for (int j = i + 1; j < n; j++) {
                if (words[j].length() >= s.length() && words[j].startsWith(s) && words[j].endsWith(s)) {
                    count += found;
                }
                if (words[j].equals(s)) {
                    found++;
                    vis[j] = true;
                }
            }
        }
        return count;
    }
}


/*
x = x.children.computeIfAbsent(key, k -> new TrieNode());
is equivalent to :
    if (!x.children.containsKey(key)) {
        x.children.put(key, new TrieNode());
    }
    x = x.children.get(key);

*/