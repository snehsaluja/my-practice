package com.practice.mypractice.programs;

import java.util.Arrays;

public class MinimumPathSum_DP_Best_64 {

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }

    public static int minPathSum_2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                int right = (j + 1 < n) ? grid[i][j + 1] : Integer.MAX_VALUE;
                int bottom = (i + 1 < m) ? grid[i + 1][j] : Integer.MAX_VALUE;
                grid[i][j] = grid[i][j] + Math.min(right, bottom);
            }
        }

        return grid[0][0];
    }


    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }


}
