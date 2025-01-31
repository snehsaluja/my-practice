package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakingALargeIsland {

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        int max = 0;
        int m = grid.length, n = grid[0].length;
        List<Integer> key = new ArrayList<>();
        int id = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, id);
                    key.add(size);
                    id++;
                }
            }
        }

        if (key.isEmpty()) {
            return 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int size = 1;
                    Set<Integer> visited = new HashSet<>();
                    for (int[] dir : directions) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (isValid(nx, ny, m, n) && grid[nx][ny] >= 2 && !visited.contains(grid[nx][ny])) {
                            size += key.get(grid[nx][ny] - 2);
                            visited.add(grid[nx][ny]);
                        }
                    }
                    max = Math.max(max, size);
                }
            }
        }
        return max == 0 ? n * n : max;
    }

    private boolean isValid(int nx, int ny, int m, int n) {
        return (nx >= 0 && nx < m && ny >= 0 && ny < n);
    }

    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        int size = 1;
        for (int[] dir : directions) {
            size += dfs(grid, i + dir[0], j + dir[1], id);
        }
        return size;
    }

    public static void main(String[] args) {
        MakingALargeIsland ob = new MakingALargeIsland();
        System.out.println(ob.largestIsland(new int[][]{{1, 0}, {0, 1}}));
    }
}
