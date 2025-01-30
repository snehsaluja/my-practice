package com.practice.mypractice.programs;

public class CountPathsWithTheGivenXORValue {

    static int MOD = 1000000007;

    public int countPathsWithXorValue(int[][] grid, int k) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        count = dfs(grid, k, visited, 0, 0, grid[0][0]);
        return count;
    }

    private int dfs(int[][] grid, int k, boolean[][] visited, int x, int y, int c) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            if (c == k) {


                return c;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
