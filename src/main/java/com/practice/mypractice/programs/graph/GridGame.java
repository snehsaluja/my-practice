package com.practice.mypractice.programs.graph;

import java.util.Arrays;

public class GridGame {

    public long gridGame(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] prefixSum = new long[m][n];

        for (int i = 0; i < m; i++) {
            prefixSum[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + grid[i][j];
            }
        }
        long tempSumForRobot2, min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long topSumForRobot2 = prefixSum[0][n - 1] - prefixSum[0][i];
            long bottomSumForRobot2 = ((i - 1) >= 0) ? prefixSum[1][i - 1] : 0;

            tempSumForRobot2 = Math.max(topSumForRobot2, bottomSumForRobot2);
            min = Math.min(min, tempSumForRobot2);
        }
        return min;
    }


    public long gridGame2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] copy = new int[m][];
        for (int i = 0; i < m; i++) {
            copy[i] = Arrays.copyOf(grid[i], n);
        }
        long[] maxVal = new long[]{0};
        long tempSum = 0;
        dfs(grid, copy, 0, 0, tempSum, maxVal);
        int[][] copy2 = new int[m][];
        copyGrid(copy, copy2);
        long max2 = dfs(copy, copy2, 0, 0, tempSum, new long[]{0});
        return max2;
    }

    private long dfs(int[][] grid, int[][] copy, int x, int y, long tempSum, long[] maxVal) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            if (tempSum > maxVal[0]) {
                maxVal[0] = tempSum;
                copyGrid(grid, copy);
                return maxVal[0];
            }
        }
        int curr = grid[x][y];
        grid[x][y] = 0;

        long rightMax = (y + 1 < grid[0].length) ? dfs(grid, copy, x, y + 1, tempSum + curr, maxVal) : 0;
        long bottomMax = (x + 1 < grid.length) ? dfs(grid, copy, x + 1, y, tempSum + curr, maxVal) : 0;
        grid[x][y] = curr;
        return Math.max(rightMax, bottomMax);
    }

    private static void copyGrid(int[][] grid, int[][] copy) {
        for (int i = 0; i < grid.length; i++) {
            copy[i] = Arrays.copyOf(grid[i], grid[0].length);
        }
    }

    public static void main(String[] args) {

    }

}
