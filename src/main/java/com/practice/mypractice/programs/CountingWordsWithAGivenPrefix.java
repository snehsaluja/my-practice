package com.practice.mypractice.programs;

public class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String w : words) {
            count += (w.startsWith(pref)) ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
