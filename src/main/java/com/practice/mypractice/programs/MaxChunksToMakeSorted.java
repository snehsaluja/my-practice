package com.practice.mypractice.programs;

public class MaxChunksToMakeSorted {

    public int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }

    public int maxChunksToSortedWithExpectedSum(int[] arr) {
        int currSum = 0, expectedSum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[0];
            expectedSum += i;
            if (currSum == expectedSum)
                count++;
        }
        return count;
    }

}
