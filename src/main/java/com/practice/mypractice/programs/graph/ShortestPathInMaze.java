package com.practice.mypractice.programs.graph;

/*
mat[ROW][COL]  =
       {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

Source = {0, 0};
Destination = {3, 4};

Output:
Shortest Path is 11

*/



import java.util.LinkedList;
import java.util.Queue;

// Agoda Round 1:


public class ShortestPathInMaze {

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};
        ShortestPathInMaze ob = new ShortestPathInMaze();
        System.out.println("DFS = " + ob.dfs(mat, 0, 0, 3, 4));
        System.out.println("BFS = " + ob.bfs(mat, 0, 0, 3, 4));

        int[][] mat2 =
               {{1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};
        System.out.println("DFS = " + ob.dfs(mat2, 0, 0, 3, 4));
        System.out.println("BFS = " + ob.bfs(mat2, 0, 0, 3, 4));

    }

    public int dfs(int arr[][], int startX, int startY, int destinationX, int destinationY) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        return dfs(arr, 0, 0, destinationX, destinationY, visited, 0, Integer.MAX_VALUE);
    }

    private int dfs(int[][] arr, int i, int j, int destinationX, int destinationY, boolean[][] visited, int steps, int minSteps) {
        int m = arr.length, n = arr[0].length;
        if (i == destinationX && j == destinationY) {
            return Math.min(steps, minSteps);
        }
        visited[i][j] = true;
        //int rightSteps = Integer.MAX_VALUE, leftSteps = Integer.MAX_VALUE, upSteps = Integer.MAX_VALUE, downSteps = Integer.MAX_VALUE;
        if (j + 1 < n && !visited[i][j + 1] && arr[i][j + 1] == 1) {
            minSteps = dfs(arr, i, j + 1, destinationX, destinationY, visited, steps + 1, minSteps);
            //rightSteps = rightSteps == -1 ? Integer.MAX_VALUE : rightSteps;
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && arr[i][j - 1] == 1) {
            minSteps = dfs(arr, i, j - 1, destinationX, destinationY, visited, steps + 1, minSteps);
        }
        if (i + 1 < m && !visited[i + 1][j] && arr[i + 1][j] == 1) {
            minSteps = dfs(arr, i + 1, j, destinationX, destinationY, visited, steps + 1, minSteps);
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && arr[i - 1][j] == 1) {
            minSteps = dfs(arr, i - 1, j, destinationX, destinationY, visited, steps + 1, minSteps);
        }

        visited[i][j] = false;
        /*int min = Math.min(rightSteps, Math.min(leftSteps, Math.min(upSteps, downSteps)));
        return min == Integer.MAX_VALUE ? -1 : min;*/
        return minSteps;
    }


    private int bfs(int[][] arr, int startX, int startY, int destinationX, int destinationY) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int m = arr.length, n = arr[0].length;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        int steps = 0, minSteps = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point curr = q.poll();
                int i = curr.x, j = curr.y;
                if (i == destinationX && j == destinationY) {
                    minSteps = Math.min(minSteps, steps);
                    break;
                }
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (j + 1 < n && !visited[i][j + 1] && arr[i][j + 1] == 1) {
                        q.offer(new Point(i, j + 1));
                    }
                    if (j - 1 >= 0 && !visited[i][j - 1] && arr[i][j - 1] == 1) {
                        q.offer(new Point(i, j - 1));
                    }
                    if (i + 1 < m && !visited[i + 1][j] && arr[i + 1][j] == 1) {
                        q.offer(new Point(i + 1, j));
                    }
                    if (i - 1 >= 0 && !visited[i - 1][j] && arr[i - 1][j] == 1) {
                        q.offer(new Point(i - 1, j));
                    }
                }

            }
            steps++;
        }
        return (minSteps == Integer.MAX_VALUE) ? -1 : minSteps;
    }

}