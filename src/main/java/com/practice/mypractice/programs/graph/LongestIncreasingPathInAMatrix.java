package com.practice.mypractice.programs.graph;

public class LongestIncreasingPathInAMatrix {

    // Time Limit Exceeded
    // This solution is plain simple DFS. Memoization is NOT being used here

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[m][n];
        if (m == 1 && n == 1) {
            return 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, visited, Integer.MIN_VALUE, i, j, m, n, 1));
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int prev, int i, int j, int m, int n, int len) {
        if (i >= m || i < 0 || j >= n || j < 0 || visited[i][j])
            return len - 1;
        if (prev >= matrix[i][j]) {
            return len-1;
        }

        visited[i][j] = true;

        int left = dfs(matrix, visited, matrix[i][j], i, j - 1, m, n, len + 1);
        int right = dfs(matrix, visited, matrix[i][j], i, j + 1, m, n, len + 1);
        int up = dfs(matrix, visited, matrix[i][j], i - 1, j, m, n, len + 1);
        int down = dfs(matrix, visited, matrix[i][j], i + 1, j, m, n, len + 1);

        visited[i][j] = false;
        return Math.max(Math.max(Math.max(up, down), right), left);
    }

    public static void main(String[] args) {
        //int[][] arr = {{6, 8}, {7, 2}};
        int[][] arr = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(arr));
    }
}
