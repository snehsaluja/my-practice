package com.practice.mypractice.programs.dp;

// LeetCode - 1043

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int currMax = 0, currSum = 0;

            for (int j = i; j >= Math.max(0, i - k + 1); j--) {

                currMax = Math.max(currMax, arr[j]);

                int cur = currMax * (i - j + 1) + dp[j];

                currSum = Math.max(cur, currSum);
            }
            dp[i + 1] = currSum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        System.out.println(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
        System.out.println(maxSumAfterPartitioning(new int[]{1}, 1));

        System.out.println(maxSumAfterPartitioningMemoization(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        System.out.println(maxSumAfterPartitioningMemoization(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
        System.out.println(maxSumAfterPartitioningMemoization(new int[]{1}, 1));
    }


    public static int maxSumAfterPartitioningMemoization(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, k, dp, 0);
    }

    private static int helper(int[] arr, int k, int[] dp, int idx) {
        int n = arr.length;
        if (idx >= n) return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int maxVal = 0, ans = 0;
        int end = Math.min(n, idx + k);
        for (int i = idx; i < end; i++) {
            maxVal = Math.max(maxVal, arr[i]);
            ans = Math.max(ans, maxVal * (i - idx + 1) + helper(arr, k, dp, i + 1));
        }

        return dp[idx] = ans;
    }
}
