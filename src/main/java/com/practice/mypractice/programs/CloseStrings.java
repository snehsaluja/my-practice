package com.practice.mypractice.programs;

import java.util.Arrays;

public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] charFreq1 = new int[26];
        int[] charFreq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            charFreq1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            charFreq2[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((charFreq1[i] > 0 && charFreq2[i] == 0) || (charFreq2[i] > 0 && charFreq1[i] == 0))
                return false;
        }
        Arrays.sort(charFreq1);
        Arrays.sort(charFreq2);
        for (int i = 0; i < 26; i++) {
            if (charFreq1[i] != charFreq2[i])
                return false;
        }
        return true;
    }
}
