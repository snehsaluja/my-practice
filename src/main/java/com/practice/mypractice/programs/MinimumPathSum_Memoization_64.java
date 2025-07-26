package com.practice.mypractice.programs;

import java.util.Arrays;

public class MinimumPathSum_Memoization_64 {

    int[][] directions = {{0, 1}, {1, 0}};

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        int min = dfs(grid, 0, 0, m, n, 0, Integer.MAX_VALUE, memo);
        return memo[m - 1][n - 1];
    }

    private int dfs(int[][] grid, int x, int y, int m, int n, int sum, int min, int[][] memo) {
        sum += grid[x][y];
        if (x == m - 1 && y == n - 1) {
            min = Math.min(min, sum);
            memo[x][y] = Math.min(memo[x][y], sum);
            return min;
        }
        if (sum < memo[x][y]) {
            memo[x][y] = sum;
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (isValidCoords(nx, ny, m, n)) {
                    min = Math.min(min, dfs(grid, nx, ny, m, n, sum, min, memo));
                }
            }
        }
        return min;
    }

    private boolean isValidCoords(int nx, int ny, int m, int n) {
        return (nx >= 0 && nx < m && ny >= 0 && ny < n);
    }

    public static void main(String[] args) {

    }


}
