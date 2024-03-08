package com.practice.mypractice.programs;

public class CountElementsWithMaximumFrequency {

    public static void main(String[] args) {

    }

    public int maxFrequencyElements(int[] nums) {
        int numberOfElementsWithMaxFreq = 0, max = 0;
        int[] freq = new int[101];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            max = Math.max(max, freq[nums[i]]);
        }
        for (int i = 0; i < 101; i++) {
            if (freq[i] == max) {
                numberOfElementsWithMaxFreq++;
            }
        }
        return numberOfElementsWithMaxFreq * max;
    }
}
