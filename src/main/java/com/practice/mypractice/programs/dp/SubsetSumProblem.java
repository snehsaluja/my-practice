package com.practice.mypractice.programs.dp;

public class SubsetSumProblem {

    static boolean isSubsetSum(int[] arr, int n, int sum) {

        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (arr[n - 1] > sum) {
            return isSubsetSum(arr, n - 1, sum);
        }

        return isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);
    }

    private static int[][] mem;

    private static void initDP(int n, int sum) {
        mem = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    mem[i][j] = 0;
                } else if (j == 0) {
                    mem[i][j] = 1;
                } else {
                    mem[i][j] = -1;
                }
            }
        }
    }

    static int isSubsetSumMemoization(int[] arr, int n, int sum) {

        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        if (mem[n][sum] != -1) {
            return mem[n][sum];
        }

        if (arr[n - 1] > sum) {
            return mem[n][sum] = isSubsetSumMemoization(arr, n - 1, sum);
        }

        return mem[n][sum] = (isSubsetSumMemoization(arr, n - 1, sum - arr[n - 1]) != 0 ||
                isSubsetSumMemoization(arr, n - 1, sum) != 0) ?
                1 : 0;
    }

    static boolean isSubsetSumDP(int[] arr, int n, int sum) {
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

    public static void main(String[] args) {
        int sum = 9;
        int n = 6;
        System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 55, 2}, n, sum));
        System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 8, 2}, n, sum));
        System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 8, 3}, n, sum));

        System.out.println("=======================================================");
        initDP(n, sum);
        System.out.println(isSubsetSumMemoization(new int[]{3, 34, 4, 12, 5, 2}, n, sum) == 1);
        initDP(n, sum);
        System.out.println(isSubsetSumMemoization(new int[]{3, 34, 4, 12, 8, 2}, n, sum) == 1);
        initDP(n, sum);
        System.out.println(isSubsetSumMemoization(new int[]{3, 34, 4, 12, 8, 3}, n, sum) == 1);

        System.out.println("=======================================================");
        System.out.println(isSubsetSumDP(new int[]{3, 34, 4, 12, 5, 2}, n, sum));
        System.out.println(isSubsetSumDP(new int[]{3, 34, 4, 12, 8, 2}, n, sum));
        System.out.println(isSubsetSumDP(new int[]{3, 34, 4, 12, 8, 3}, n, sum));
    }
}
