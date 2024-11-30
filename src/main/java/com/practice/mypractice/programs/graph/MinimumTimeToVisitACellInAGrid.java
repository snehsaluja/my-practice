package com.practice.mypractice.programs.graph;

import java.util.PriorityQueue;

public class MinimumTimeToVisitACellInAGrid {

    /*public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int time = dfs(grid, 0, 0, m, n, visited, 0);
        return time == Integer.MAX_VALUE ? -1 : time;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited, int time) {

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] > time)
            return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1 && grid[i][j] <= time) {
            return time;
        }

        visited[i][j] = true;
        int calculatedTime = Integer.MAX_VALUE;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            calculatedTime = Math.min(calculatedTime, dfs(grid, nx, ny, m, n, visited, time + 1));
        }

        visited[i][j] = false;
        return calculatedTime;
    }*/

    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (grid[0][1] > 1 || grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        pq.offer(new int[]{0, 0, 0});       // time, i , j
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int i = curr[1];
            int j = curr[2];

            for (int[] dir : directions) {
                int nx = i + dir[0];
                int ny = j + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny])
                    continue;

                int newTime = time + 1;
                if (grid[nx][ny] > newTime) {
                    int wait = ((grid[nx][ny] - time + 1) / 2) * 2;
                    //int diff = grid[nx][ny] - time;
                    //newTime = (diff % 2) == 0 ? grid[nx][ny] + 1 : grid[nx][ny];
                    newTime += wait;
                }
                if (nx == m - 1 && ny == n - 1) {
                    return newTime;
                }
                visited[nx][ny] = true;
                pq.offer(new int[]{newTime, nx, ny});
            }

        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
