package com.practice.mypractice.programs.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumCostToMakeAtLeastOneValidPathInAGrid {

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] minCost = new int[m][n];
        for (int[] c : minCost) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        minCost[0][0] = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                int cost = (grid[x][y] == (i + 1)) ? 0 : 1;
                if (isValid(nx, ny, m, n) && (minCost[x][y] + cost < minCost[nx][ny])) {
                    minCost[nx][ny] = minCost[x][y] + cost;
                    if (cost == 1) {
                        q.offerLast(new int[]{nx, ny});
                    } else {
                        q.offerFirst(new int[]{nx, ny});
                    }
                }
            }
        }
        return minCost[m - 1][n - 1];
    }

    private boolean isValid(int nx, int ny, int m, int n) {
        return (nx >= 0 && nx < m && ny >= 0 && ny < n);
    }

    public static void main(String[] args) {

    }

}
