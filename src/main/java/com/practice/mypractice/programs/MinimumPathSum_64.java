package com.practice.mypractice.programs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPathSum_64 {

    int[][] directions = {{0, 1}, {1, 0}};

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int min = dfs(grid, 0, 0, m, n, 0, Integer.MAX_VALUE);
        return min;
    }

    private int dfs(int[][] grid, int x, int y, int m, int n, int sum, int min) {
        if (x == m - 1 && y == n - 1) {
            sum += grid[x][y];
            min = Math.min(min, sum);
            return min;
        }

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (isValidCoords(nx, ny, m, n)) {
                min = Math.min(min, dfs(grid, nx, ny, m, n, sum + grid[x][y], min));
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
