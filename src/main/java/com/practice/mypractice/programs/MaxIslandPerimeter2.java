package com.practice.mypractice.programs;

public class MaxIslandPerimeter2 {


    public static void main(String[] args) {
        MaxIslandPerimeter2 obj = new MaxIslandPerimeter2();

        int[][] grid1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 1}
        };
        System.out.println(obj.maxPerimeter(grid1));  // Expected output: 7

        int[][] grid2 = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(obj.maxPerimeter(grid2));  // Expected output: 9
    }

    boolean visited[][];


    public int maxPerimeter(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        visited = new boolean[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, perimeter(grid, i, j));
                }
            }
        }
        return max;
    }

    private int perimeter(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
            return 0;
        }
        // else it means we are at '1' right now.
        int currentPerimeter = 0, leftPeri = 0, rightPeri = 0, topPeri = 0, bottomPeri = 0;
        if (i - 1 < 0 || i + 1 >= grid.length || j - 1 < 0 || j + 1 >= grid[0].length ||
                grid[i - 1][j] == 0 || grid[i + 1][j] == 0 || grid[i][j - 1] == 0 || grid[i][j + 1] == 0) {
            currentPerimeter = 1;
        }
        grid[i][j] = 2;
        leftPeri = perimeter(grid, i, j - 1);
        rightPeri = perimeter(grid, i, j + 1);
        topPeri = perimeter(grid, i - 1, j);
        bottomPeri = perimeter(grid, i + 1, j);

        return currentPerimeter + leftPeri + rightPeri + topPeri + bottomPeri;

    }
}
