package com.practice.mypractice.programs;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(rec(cost, 0), rec(cost, 1));
    }

    int[] dp;

    private int rec(int[] arr, int n) {
        if (n >= arr.length) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = arr[n] + Math.min(rec(arr, n + 1), rec(arr, n + 2));
        return dp[n];
    }

    // Applying Bottom-UP DP :
    public int minCostClimbingStairsDP(int[] cost) {
        int n = cost.length;
        int[] deepee = new int[n];
        if (n == 1) {
            return cost[0];
        }
        deepee[0] = cost[0];
        deepee[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            deepee[i] = cost[i] + Math.min(deepee[i - 1], deepee[i - 2]);
        }
        return Math.min(deepee[n - 1], deepee[n - 2]);
    }


    public static void main(String[] args) {

    }
}
