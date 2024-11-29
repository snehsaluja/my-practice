package com.practice.mypractice.programs.graph;

public class MaxAreaIsland {

    public static void main(String[] args) {
        int M[][] = {
                {1, 1, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0}
        };

        System.out.println(maxArea(M));

        int M2[][] = {
                {1, 1},
                {1, 1}
        };
        System.out.println(maxArea(M2));

        int M3[][] = {
                {0, 0},
                {0, 0}
        };
        System.out.println(maxArea(M3));

        int M4[][] = {
                {0, 0},
                {0, 1}
        };
        System.out.println(maxArea(M4));

    }

    public static int maxArea(int[][] arr) {

        int maxArea = 0, m = arr.length, n = arr[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(arr, visited, i, j));
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] arr, boolean[][] visited, int i, int j) {
        if (!isValid(i, j, arr))
            return 0;
        if (visited[i][j])
            return 0;
        visited[i][j] = true;

        int areaUp = dfs(arr, visited, i - 1, j);
        int areaDown = dfs(arr, visited, i + 1, j);
        int areaRight = dfs(arr, visited, i, j + 1);
        int areaLeft = dfs(arr, visited, i, j - 1);

        return 1 + areaUp + areaLeft + areaDown + areaRight;
    }

    private static boolean isValid(int i, int j, int[][] arr) {
        return (i < arr.length && i >= 0 && j < arr[0].length && j >= 0 && arr[i][j] == 1);
    }
}
