package com.practice.mypractice.programs;

public class ConstructKPalindromeStrings {

    public boolean canConstruct(String s, int k) {
        if (k == s.length()) {
            return true;
        }
        if (k > s.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int countOfSingleFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                countOfSingleFreq++;
            }
        }

        return !(countOfSingleFreq > k);
    }

    public static void main(String[] args) {

    }
}
