package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        boolean found = false;
        outer:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endWord)) {
                    found = true;
                    break outer;
                }
                for (String word : wordList) {
                    if (!visited.contains(word) && canTransform(curr, word)) {
                        visited.add(word);
                        q.offer(word);
                    }
                }
                count++;
            }
        }
        return found ? count : 0;
    }

    private boolean canTransform(String curr, String word) {
        /*if (curr.length() != word.length()) {
            return false;
        }*/
        int count = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count != 1;
    }

    public static void main(String[] args) {
        WordLadder_127 ob = new WordLadder_127();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(ob.ladderLength(beginWord, endWord, wordList));
    }
}
