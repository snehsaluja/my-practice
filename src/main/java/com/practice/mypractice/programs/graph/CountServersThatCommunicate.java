package com.practice.mypractice.programs.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length, connectedServers = 0;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    connectedServers++;
                }
            }
        }
        return connectedServers;
    }

    public int countServersWrong(int[][] grid) {
        int m = grid.length, n = grid[0].length, connectedServers = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int connectedCount = dfs(grid, i, j);
                    if (connectedCount > 1) {
                        connectedServers += connectedCount;
                    }
                }
            }
        }

        return connectedServers;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        int right = dfs(grid, i, j + 1);
        int left = dfs(grid, i, j - 1);
        int up = dfs(grid, i + 1, j);
        int down = dfs(grid, i - 1, j);

        return 1 + left + right + up + down;
    }

}
