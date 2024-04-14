package com.practice.mypractice.programs;

public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < arr.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            sum += (max * k);
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
