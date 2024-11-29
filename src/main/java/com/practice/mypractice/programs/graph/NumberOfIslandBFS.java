package com.practice.mypractice.programs.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandBFS {
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
                    bfs(arr, i, j, visited);
                }
            }
        }

        return islands;
    }

    private static void bfs(int[][] arr, int i, int j, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        while (!q.isEmpty()) {
            Point curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            if (!visited[x][y]) {
                visited[x][y] = true;
                // add right, left, up, down
                addAdjacentToQueue(q, x, y, visited, arr);
            }
        }
    }

    private static void addAdjacentToQueue(Queue<Point> q, int x, int y, boolean[][] visited, int[][] arr) {
        int m = arr.length, n = arr[0].length;
        // up, down, right, left:
        if (x + 1 < m && !visited[x + 1][y] && arr[x + 1][y] == 1) {
            q.offer(new Point(x + 1, y));
        }
        if (x - 1 >= 0 && !visited[x - 1][y] && arr[x - 1][y] == 1) {
            q.offer(new Point(x - 1, y));
        }
        if (y + 1 < n && !visited[x][y + 1] && arr[x][y + 1] == 1) {
            q.offer(new Point(x, y + 1));
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && arr[x][y - 1] == 1) {
            q.offer(new Point(x, y - 1));
        }
        // Diagonals :
        if (x - 1 >= 0 && y + 1 < n && !visited[x - 1][y + 1] && arr[x - 1][y + 1] == 1) {
            q.offer(new Point(x - 1, y + 1));
        }
        if (x + 1 < m && y + 1 < n && !visited[x + 1][y + 1] && arr[x + 1][y + 1] == 1) {
            q.offer(new Point(x + 1, y + 1));
        }
        if (x + 1 < m && y - 1 >= 0 && !visited[x + 1][y - 1] && arr[x + 1][y - 1] == 1) {
            q.offer(new Point(x + 1, y - 1));
        }
        if (x - 1 >= 0 && y - 1 >= 0 && !visited[x - 1][y - 1] && arr[x - 1][y - 1] == 1) {
            q.offer(new Point(x - 1, y - 1));
        }
    }
}
