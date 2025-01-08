package com.practice.mypractice.programs.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int freshCount = 0, m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0)
            return 0;

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] rotten = queue.poll();
                for (int[] dir : directions) {
                    int nx = rotten[0] + dir[0];
                    int ny = rotten[1] + dir[1];
                    if (isValid(nx, ny, m, n) && grid[nx][ny] == 1) {
                        freshCount--;
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            if (!queue.isEmpty()) {
                time++;
            }
        }

        return (freshCount > 0) ? -1 : time;
    }

    private boolean isValid(int nx, int ny, int m, int n) {
        return (nx >= 0 && nx < m && ny >= 0 && ny < n);
    }

    public static void main(String[] args) {

    }
}
