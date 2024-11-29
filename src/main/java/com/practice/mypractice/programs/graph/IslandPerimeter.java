package com.practice.mypractice.programs.graph;

public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0}
        };

        System.out.println(islandPerimeter(M));

        int[][] M2 = {
                {1, 1},
                {1, 1}
        };
        System.out.println(islandPerimeter(M2));

        int[][] M3 = {
                {0, 0},
                {0, 0}
        };
        System.out.println(islandPerimeter(M3));

        int[][] M4 = {
                {0, 0},
                {0, 1}
        };
        System.out.println(islandPerimeter(M4));

    }

    public   static int islandPerimeter(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    int perimeter = dfsPerimeterCalc(arr, visited, i, j);
                    return perimeter;
                }
            }
        }
        return 0;
    }

    private static int dfsPerimeterCalc(int[][] arr, boolean[][] visited, int i, int j) {
        if (isOutsideBorder(i, j, arr))
            return 1;
        else if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int up = dfsPerimeterCalc(arr, visited, i - 1, j);
        int down = dfsPerimeterCalc(arr, visited, i + 1, j);
        int right = dfsPerimeterCalc(arr, visited, i, j + 1);
        int left = dfsPerimeterCalc(arr, visited, i, j - 1);

        return up + down + right + left;
    }

    private static boolean isOutsideBorder(int i, int j, int[][] arr) {
        int m = arr.length, n = arr[0].length;
        return (i < 0 || i >= m || j < 0 || j >= n || arr[i][j] != 1);
    }

}
