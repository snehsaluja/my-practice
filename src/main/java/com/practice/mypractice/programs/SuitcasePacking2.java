/*
package com.practice.mypractice.programs;
import java.util.Arrays;

public class SuitcasePacking2 {
    public static int maxWeight(int[] weights, int w1, int w2) {
        int n = weights.length;
        return knapsack(weights, w1, w2, n);
    }

    private static int knapsack(int[] weights, int w1, int w2, int n) {
        int[][] dp = new int[n + 1][w1 + 1];

        // Solve 0/1 Knapsack for suitcase 1
        for (int i = 1; i <= n; i++) {
            for (int j = w1; j >= weights[i - 1]; j--) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + weights[i - 1]);
            }
            for (int j = 0; j < weights[i - 1]; j++) {
                dp[i][j] = dp[i - 1][j];
            }
        }

        int maxW1 = dp[n][w1];

        // Solve 0/1 Knapsack for suitcase 2 with remaining items
        boolean[] used = new boolean[n];
        int remainingCapacity = w1;
        for (int i = n; i > 0 && maxW1 > 0; i--) {
            if (maxW1 != dp[i - 1][remainingCapacity]) {
                used[i - 1] = true;
                maxW1 -= weights[i - 1];
                remainingCapacity -= weights[i - 1];
            }
        }

        // Create a new list of items that were not used in the first knapsack
        */
/*int[] remainingItems = Arrays.stream(weights)
                .filter((i, idx) -> !used[idx])
                .toArray();*//*


        int maxW2 = knapsackHelper(remainingItems, w2);

        return dp[n][w1] + maxW2;
    }

    private static int knapsackHelper(int[] weights, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int weight : weights) {
            for (int j = capacity; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + weight);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = {10, 8, 3, 8};
        int w1 = 5, w2 = 17;
        System.out.println(maxWeight(weights, w1, w2));  // Output: 19
    }
}
*/
