package com.practice.mypractice.programs;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram2 {

    public int minSteps(String s, String t) {
        int[] charFreq = new int[26];
        for (char ch : s.toCharArray()) {
            charFreq[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            charFreq[ch - 'a']--;
        }
        int count = 0;
        for (int i : charFreq) {
            count += Math.abs(i);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
