package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static int findMaxWeight(int curr, int n, int[] arr,
                             int capacity1, int capacity2) {

        // Base case: if all items have been considered
        if (curr >= n)
            return 0;

        // Option 1: Don't take the current item
        int res = findMaxWeight(curr + 1, n, arr,
                capacity1, capacity2);

        // Option 2: If the current item can be
        // added to the first knapsack, do it
        if (capacity1 >= arr[curr]) {
            int takeInFirst
                    = arr[curr]
                    + findMaxWeight(curr + 1, n, arr,
                    capacity1 - arr[curr], capacity2);
            res = Math.max(res, takeInFirst);
        }

        // Option 3: If the current item can be
        // added to the second knapsack, do it
        if (capacity2 >= arr[curr]) {
            int takeInSecond
                    = arr[curr]
                    + findMaxWeight(curr + 1, n, arr, capacity1,
                    capacity2 - arr[curr]);
            res = Math.max(res, takeInSecond);
        }

        return res;
    }

    static int maxWeight(int[] arr, int capacity1, int capacity2) {
        int n = arr.length;
        int res = findMaxWeight(0, n, arr, capacity1, capacity2);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 3, 8};
        int capacity1 = 5, capacity2 = 17;
        int res = maxWeight(arr, capacity1, capacity2);
        List<Integer> arrayList = new ArrayList<>();
        for (int num : arr) {
            arrayList.add(num);
        }
        int res2 = maxWeight(arrayList, 5, 17);
        System.out.println(res);
        System.out.println(res2);
    }

    static int maxWeight(List<Integer> arr, int w1,
                         int w2) {
        int n = arr.size();

        // Initialize a 3D DP array with dimensions (n+1) x
        // (w1+1) x (w2+1)
        int[][][] dp = new int[n + 1][w1 + 1][w2 + 1];

        // Fill the DP array iteratively
        for (int i = 1; i <= n; i++) {
            int weight = arr.get(i - 1);
            for (int j = 0; j <= w1; j++) {
                for (int k = 0; k <= w2; k++) {

                    // Option 1: Don't take the current item
                    dp[i][j][k] = dp[i - 1][j][k];

                    // Option 2: Take the current item in
                    // the first knapsack, if possible
                    if (j >= weight) {
                        dp[i][j][k] = Math.max(
                                dp[i][j][k],
                                weight
                                        + dp[i - 1][j - weight][k]);
                    }

                    // Option 3: Take the current item in
                    // the second knapsack, if possible
                    if (k >= weight) {
                        dp[i][j][k] = Math.max(
                                dp[i][j][k],
                                weight
                                        + dp[i - 1][j][k - weight]);
                    }
                }
            }
        }

        return dp[n][w1][w2];
    }
}


