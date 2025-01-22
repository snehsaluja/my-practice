package com.practice.mypractice.programs.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int[] h : height) {
            Arrays.fill(h, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if (isValid(nx, ny, height) && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return height;
    }

    private static boolean isValid(int nx, int ny, int[][] height) {
        return (nx >= 0 && nx < height.length && ny >= 0 && ny < height[0].length);
    }

    public static void main(String[] args) {
        System.out.println(highestPeak(new int[][]{{0, 1}, {0, 0}}));
    }
}
