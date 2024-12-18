package com.practice.mypractice.programs;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        int count = 0;
        for (int i = 0; i < 128; i++) {
            count += freq[i] - freq[i] % 2;
        }
        return (count == s.length()) ? count : count + 1;
    }

    public static void main(String[] args) {

    }
}
