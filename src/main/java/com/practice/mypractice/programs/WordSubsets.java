package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] maxFreq = new int[26];
        for (int i = 0; i < words2.length; i++) {
            int[] freq = new int[26];
            String w = words2[i];
            for (char ch : w.toCharArray()) {
                freq[ch - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                maxFreq[j] = Math.max(maxFreq[j], freq[j]);
            }
        }

        for (String w : words1) {
            int[] w1freq = new int[26];
            for (char ch : w.toCharArray()) {
                w1freq[ch - 'a']++;
            }
            boolean flag = true;
            for (int k = 0; k < 26; k++) {
                if (w1freq[k] < maxFreq[k]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                result.add(w);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
