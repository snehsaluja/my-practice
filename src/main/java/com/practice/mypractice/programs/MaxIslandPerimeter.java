package com.practice.mypractice.programs;

public class MaxIslandPerimeter {
    int maxPeri = 0;

    public int maxPerimeterOfIsland(int[][] grid) {
        // Write your code here
        int n = grid.length, m = grid[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxPeri = Math.max(dfs(grid, i, j), maxPeri);
                }
            }
        }
        return maxPeri;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
            return 0;
        }

        int currPeri = 0, left = 0, right = 0, top = 0, bottom = 0;
        boolean isValid = checkIsValidCandidate(grid, i, j);
        // System.out.println(isValid + " i "+ i + " j " + j);
        if (isValid) {
            currPeri = 1;
        }

        grid[i][j] = 2;
        // dfs
        left = dfs(grid, i - 1, j);
        right = dfs(grid, i + 1, j);
        top = dfs(grid, i, j - 1);
        bottom = dfs(grid, i, j + 1);
        return currPeri + left + right + top + bottom;
    }

    private boolean checkIsValidCandidate(int[][] grid, int i, int j) {
        boolean ans = false;

        // Any corner
        // if(i<0 || j<0 ||i>=grid.length || j>=grid[0].length){
        //     return true;
        // }

        if (grid[i][j] == 0) {
            return false;
        }
        if (i > 0 && grid[i - 1][j] == 0) {
            return true;
        } else if (i == 0) {
            return true;
        }

        if (j > 0 && grid[i][j - 1] == 0) {
            return true;
        } else if (j == 0) {
            return true;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 0) {
            return true;
        } else if (i == grid.length - 1) {
            return true;
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
            return true;
        } else if (j == grid[0].length - 1) {
            return true;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxIslandPerimeter solution = new MaxIslandPerimeter();

        int[][] grid1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 1}
        };
        System.out.println(solution.maxPerimeterOfIsland(grid1));  // Expected output: 7

        int[][] grid2 = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(solution.maxPerimeterOfIsland(grid2));  // Expected output: 9
    }
}