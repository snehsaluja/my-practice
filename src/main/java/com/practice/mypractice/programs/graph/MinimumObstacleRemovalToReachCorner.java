package com.practice.mypractice.programs.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumObstacleRemovalToReachCorner {

    //DFS
    // ********************************************************************************************************************************
    public int minimumObstaclesDFS(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfsRemoveObstacles(grid, 0, 0, m, n, visited, 0);
    }

    private int dfsRemoveObstacles(int[][] grid, int i, int j, int m, int n, boolean[][] visited, int removedBlocks) {
        // TIME LIMIT EXCEEDED !!
        if (!isValidPosition(i, j, m, n) || visited[i][j])
            return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1) {
            return removedBlocks;
        }
        visited[i][j] = true;
        if (grid[i][j] == 1) {
            removedBlocks++;
        }

        int up = dfsRemoveObstacles(grid, i - 1, j, m, n, visited, removedBlocks);
        int down = dfsRemoveObstacles(grid, i + 1, j, m, n, visited, removedBlocks);
        int right = dfsRemoveObstacles(grid, i, j + 1, m, n, visited, removedBlocks);
        int left = dfsRemoveObstacles(grid, i, j - 1, m, n, visited, removedBlocks);

        visited[i][j] = false;
        return Math.min(Math.min(Math.min(up, down), right), left);
    }

    private boolean isValidPosition(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }


    // BFS
    // ********************************************************************************************************************************
    public int minimumObstacles(int[][] grid) {
        return bfsRemoveObstacles(grid);
    }

    private int bfsRemoveObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newDist = distance[x][y] + grid[nx][ny];
                    if (newDist < distance[nx][ny]) {
                        distance[nx][ny] = newDist;
                        if (grid[nx][ny] == 0) {
                            q.offerFirst(new int[]{nx, ny});
                        } else {
                            q.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }

        }
        return distance[m - 1][n - 1];
    }


}
