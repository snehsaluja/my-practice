package com.practice.mypractice.programs;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        int[] charFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 97]++;
            charFreq[t.charAt(i) - 97]--;
        }


        /*for (char ch : s.toCharArray()) {
            charFreq[ch - 97]++;
        }
        for (char ch : t.toCharArray()) {
            charFreq[ch - 97]--;
        }*/

        int count = 0;
        for (int freq : charFreq) {
            count += Math.abs(freq);
        }
        return count / 2;
    }

    public static void main(String[] args) {

    }
}
