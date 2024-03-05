package com.practice.mypractice.programs.dp;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        int n = 3, w = 9;
        int[] profit = {1, 2, 3}, weight = {4, 5, 1};
        System.out.println(knapsackRecursive(profit, weight, w, n));

        dpMem = new int[n + 1][w + 1];
        Arrays.stream(dpMem).forEach(arr -> Arrays.fill(arr, -1));
        //Arrays.stream(dpMem).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println(knapsackMemoization(profit, weight, w, n));

        System.out.println(knapsackTopDown(profit, weight, w, n));
    }

    private static int knapsackRecursive(int[] profit, int[] weight, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        // Choice diagram/Decision Tree:
        if (weight[n - 1] <= w) {
            // Max of (We want to include or,  we dont want to include.)
            return Math.max(profit[n - 1] + knapsackRecursive(profit, weight, w - weight[n - 1], n - 1),
                    knapsackRecursive(profit, weight, w, n - 1));
        } else {
            // if weight is less than remaining weight, then skip this item
            return knapsackRecursive(profit, weight, w, n - 1);
        }
    }

    static int[][] dpMem;

    private static int knapsackMemoization(int[] profit, int[] weight, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (dpMem[n][w] != -1) {
            return dpMem[n][w];
        }

        if (weight[n - 1] <= w) {
            dpMem[n - 1][w - 1] = Math.max(profit[n - 1] + knapsackRecursive(profit, weight, w - weight[n - 1], n - 1),
                    knapsackRecursive(profit, weight, w, n - 1));
        } else {
            dpMem[n - 1][w - 1] = knapsackRecursive(profit, weight, w, n - 1);
        }

        return dpMem[n - 1][w - 1];
    }

    private static int knapsackTopDown(int[] profit, int[] weight, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(profit[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }
}