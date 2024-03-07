package com.practice.mypractice.programs;

public class NumberOfIslands {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]
                {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(numIslands(new char[][]
                {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

    public static int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private static void dfs(char[][] grid, int i, int j) {
        grid[i][j] = 'v';       // marking this as "visited"
        if (i > 0 && grid[i - 1][j] == '1')
            dfs(grid, i - 1, j);
        if (i + 1 < grid.length && grid[i + 1][j] == '1')
            dfs(grid, i + 1, j);
        if (j > 0 && grid[i][j - 1] == '1')
            dfs(grid, i, j - 1);
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1')
            dfs(grid, i, j + 1);
    }
}
