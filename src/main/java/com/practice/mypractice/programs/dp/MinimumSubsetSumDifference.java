package com.practice.mypractice.programs.dp;

import java.util.Arrays;

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        System.out.println(minimumDifferenceOfSubsetSum(new int[]{1, 6, 11, 5}));
        System.out.println(minimumDifferenceOfSubsetSum(new int[]{11}));
        System.out.println(minimumDifferenceOfSubsetSum(new int[]{11, 11}));
        System.out.println(minimumDifferenceOfSubsetSum(new int[]{1, 6, 12, 5}));
        System.out.println(minimumDifferenceOfSubsetSum(new int[]{1, 3, 11, 5}));
        System.out.println(minimumDifferenceOfSubsetSum(new int[]{10, 9, 8, 14, 15, 16}));
    }

    public static int minimumDifferenceOfSubsetSum(int[] arr) {

        int sum = Arrays.stream(arr).sum(), n = arr.length;
        boolean[][] dp = getSubsetSumDPMatrix(arr, sum);
        int i;
        for (i = sum / 2; i >= 0; i--) {
            if (dp[n][i]) {
                break;
            }
        }
        return (i >= 0) ? (sum - 2 * i) : sum;
    }

    private static boolean[][] getSubsetSumDPMatrix(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp;
    }
}
