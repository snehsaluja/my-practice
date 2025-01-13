package com.practice.mypractice.programs;

public class MinimumLengthOfStringAfterOperations {

    public int minimumLength(String s) {
        int count = 0;
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 2 && freq[i] % 2 == 0) {
                count += 2;
            } else if (freq[i] > 2 && freq[i] % 2 == 1) {
                count += 1;
            } else {
                count += freq[i];
            }
        }
        return count;
    }

    public int minimumLength2(String s) {
        int count = 0;
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            if (freq[i] % 2 == 0) {     // Even Frequency
                count += 2;
            } else {                    // Odd Frequency
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
