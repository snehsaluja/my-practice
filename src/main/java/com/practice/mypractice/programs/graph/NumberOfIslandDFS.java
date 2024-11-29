package com.practice.mypractice.programs.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandDFS {
    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0}
        };

        System.out.println(countIslands(M));

        int[][] M2 = {
                {1, 1},
                {1, 1}
        };
        System.out.println(countIslands(M2));

        int[][] M3 = {
                {0, 0},
                {0, 0}
        };
        System.out.println(countIslands(M3));

        int[][] M4 = {
                {0, 0},
                {0, 1}
        };
        System.out.println(countIslands(M4));

    }

    public static int countIslands(int[][] arr) {

        int m = arr.length, n = arr[0].length, islands = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    islands++;
                    dfs(arr, i, j, visited);
                }
            }
        }

        return islands;
    }

    private static void dfs(int[][] arr, int x, int y, boolean[][] visited) {
        int m = arr.length, n = arr[0].length;
        visited[x][y] = true;
        // up, down, right, left:
        if (x + 1 < m && !visited[x + 1][y] && arr[x + 1][y] == 1) {
            dfs(arr, x + 1, y, visited);
        }
        if (x - 1 >= 0 && !visited[x - 1][y] && arr[x - 1][y] == 1) {
            dfs(arr, x - 1, y, visited);
        }
        if (y + 1 < n && !visited[x][y + 1] && arr[x][y + 1] == 1) {
            dfs(arr, x, y + 1, visited);
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && arr[x][y - 1] == 1) {
            dfs(arr, x, y - 1, visited);
        }
        // Diagonals :
        if (x - 1 >= 0 && y + 1 < n && !visited[x - 1][y + 1] && arr[x - 1][y + 1] == 1) {
            dfs(arr, x - 1, y + 1, visited);
        }
        if (x + 1 < m && y + 1 < n && !visited[x + 1][y + 1] && arr[x + 1][y + 1] == 1) {
            dfs(arr, x + 1, y + 1, visited);
        }
        if (x + 1 < m && y - 1 >= 0 && !visited[x + 1][y - 1] && arr[x + 1][y - 1] == 1) {
            dfs(arr, x + 1, y - 1, visited);
        }
        if (x - 1 >= 0 && y - 1 >= 0 && !visited[x - 1][y - 1] && arr[x - 1][y - 1] == 1) {
            dfs(arr, x - 1, y - 1, visited);
        }
    }

    private static void addAdjacentToQueue(Queue<Point> q, int x, int y, boolean[][] visited, int[][] arr) {

    }
}
