package com.practice.mypractice.programs.dp;

public class CountSubsetWithGivenSum {

    public static void main(String[] args) {
        System.out.println(countSubsetWithSum(new int[]{2, 3, 5, 6, 8, 10}, 10));
        System.out.println(countSubsetWithSum(new int[]{2, 3, 5, 6, 8, 10}, 16));
        System.out.println(countSubsetWithSum(new int[]{2, 3, 5, 6, 8, 10}, 15));
    }

    public static int countSubsetWithSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
