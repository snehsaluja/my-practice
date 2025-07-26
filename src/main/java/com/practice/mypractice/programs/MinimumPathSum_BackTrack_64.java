package com.practice.mypractice.programs;

import java.util.Arrays;

public class MinimumPathSum_BackTrack_64 {

    int[][] directions = {{0, 1}, {1, 0}};

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = m - 2; i >= 0; i--) {
            updateGrid(grid, i, n - 1, m, n);
        }
        for (int j = n - 2; j >= 0; j--) {
            updateGrid(grid, 0, j, m, n);
        }
        return grid[0][0];
    }

    private void updateGrid(int[][] grid, int i, int j, int m, int n) {
        int min;
        while (i >= 0 && i < m && j >= 0 && j < n) {
            min = Integer.MAX_VALUE;

            if (i < m - 1) {
                min = grid[i + 1][j];
            }
            if (j < n - 1) {
                min = Math.min(min, grid[i][j + 1]);
            }
            grid[i][j] += min;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

    }


}
