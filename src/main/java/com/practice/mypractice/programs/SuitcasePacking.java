package com.practice.mypractice.programs;

import java.util.Arrays;

public class SuitcasePacking {
    /*public static int maxWeight(int[] weights, int w1, int w2) {
        int n = weights.length;
        int totalSum = Arrays.stream(weights).sum();
        int maxCapacity = Math.min(totalSum, w1 + w2);  // Maximum weight that can be achieved

        // DP to find max weight that can be packed in w1
        boolean[] dp = new boolean[w1 + 1];
        dp[0] = true;

        for (int weight : weights) {
            for (int j = w1; j >= weight; j--) {
                dp[j] |= dp[j - weight];
            }
        }

        // Find the maximum weight that can be put in suitcase 1
        int maxW1 = 0;
        for (int i = w1; i >= 0; i--) {
            if (dp[i]) {
                maxW1 = i;
                break;
            }
        }

        // Remaining weight goes into suitcase 2
        int maxW2 = Math.min(w2, totalSum - maxW1);

        return maxW1 + maxW2;
    }*/

    public static void main(String[] args) {
        int[] weights = {10, 8, 3, 8};
        int w1 = 5;
        int w2 = 17;
        System.out.println(maxWeight(weights, w1, w2)); // Output: 19

        int[] weights2 = {4, 7, 2, 9, 5};
        int w1_2 = 10;
        int w2_2 = 12;
        System.out.println(maxWeight(weights2, w1_2, w2_2)); // Expected Output: 19
    }

    public static int maxWeight(int[] weights, int w1, int w2) {
        /*int n = weights.length;

        // Using 0/1 Knapsack DP approach for suitcase 1
        boolean[][] dp1 = new boolean[n + 1][w1 + 1];
        dp1[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = w1; j >= 0; j--) {
                if (dp1[i - 1][j]) {
                    dp1[i][j] = true;
                    if (j + weights[i - 1] <= w1) {
                        dp1[i][j + weights[i - 1]] = true;
                    }
                }
            }
        }

        // Finding maximum weight that can be put in suitcase 1
        int maxW1 = 0;
        for (int i = w1; i >= 0; i--) {
            if (dp1[n][i]) {
                maxW1 = i;
                break;
            }
        }

        // Finding remaining items for suitcase 2
        boolean[] used = new boolean[n];
        int w = maxW1;
        for (int i = n; i > 0 && w > 0; i--) {
            if (!dp1[i - 1][w]) {
                used[i - 1] = true;
                w -= weights[i - 1];
            }
        }

        // Using 0/1 Knapsack DP approach for suitcase 2
        boolean[][] dp2 = new boolean[n + 1][w2 + 1];
        dp2[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (used[i - 1]) continue; // Skip items already placed in suitcase 1
            for (int j = w2; j >= 0; j--) {
                if (dp2[i - 1][j]) {
                    dp2[i][j] = true;
                    if (j + weights[i - 1] <= w2) {
                        dp2[i][j + weights[i - 1]] = true;
                    }
                }
            }
        }

        // Finding maximum weight that can be put in suitcase 2
        int maxW2 = 0;
        for (int i = w2; i >= 0; i--) {
            if (dp2[n][i]) {
                maxW2 = i;
                break;
            }
        }

        return maxW1 + maxW2;*/

        int n = weights.length;
        int totalSum = Arrays.stream(weights).sum();
        int maxCapacity = Math.min(totalSum, w1 + w2);  // Maximum weight that can be packed

        // DP array: dp[i] stores whether weight `i` can be achieved using a subset of weights
        boolean[] dp = new boolean[maxCapacity + 1];
        dp[0] = true;

        // Compute all achievable weights
        for (int weight : weights) {
            for (int j = maxCapacity; j >= weight; j--) {
                dp[j] |= dp[j - weight];
            }
        }

        // Find the best way to distribute between w1 and w2
        int maxWeight = 0;
        for (int i = 0; i <= w1; i++) {
            if (dp[i]) {
                int remainingWeight = Math.min(w2, totalSum - i);
                maxWeight = Math.max(maxWeight, i + remainingWeight);
            }
        }

        return maxWeight;
    }
}
