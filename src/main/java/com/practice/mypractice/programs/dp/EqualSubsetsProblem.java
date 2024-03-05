package com.practice.mypractice.programs.dp;

import java.util.Arrays;

public class EqualSubsetsProblem {

    public static void main(String[] args) {
        System.out.println(isEqualSumSubsetPresent(new int[]{1, 5, 11, 5}));
        System.out.println(isEqualSumSubsetPresent(new int[]{1, 5, 11, 4}));
        System.out.println(isEqualSumSubsetPresent(new int[]{1, 5, 10, 4}));
        System.out.println(isEqualSumSubsetPresent(new int[]{2, 5, 19, 8, 55, 3, 4}));
        System.out.println(isEqualSumSubsetPresent(new int[]{2, 5, 19, 8, 55, 3, 4, 30}));
    }

    public static boolean isEqualSumSubsetPresent(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0)
            return false;
        return isSubsetSum(arr, sum / 2);
    }

    private static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int j = 0; j < sum + 1; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
