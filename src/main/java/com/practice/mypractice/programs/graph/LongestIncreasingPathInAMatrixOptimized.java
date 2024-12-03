package com.practice.mypractice.programs.graph;

public class LongestIncreasingPathInAMatrixOptimized {

    // This solution is DFS with Memoization being used here.
    // Hence, Output is within Time Limit.

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = Integer.MIN_VALUE;
        int[][] memo = new int[m][n];
        if (m == 1 && n == 1) {
            return 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, memo, Integer.MIN_VALUE, i, j, m, n));
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int[][] memo, int prev, int i, int j, int m, int n) {
        if (i >= m || i < 0 || j >= n || j < 0)
            return 0;
        if (prev >= matrix[i][j]) {
            return 0;
        }
        if (memo[i][j] != 0)
            return memo[i][j];

        int left = dfs(matrix, memo, matrix[i][j], i, j - 1, m, n);
        int right = dfs(matrix, memo, matrix[i][j], i, j + 1, m, n);
        int up = dfs(matrix, memo, matrix[i][j], i - 1, j, m, n);
        int down = dfs(matrix, memo, matrix[i][j], i + 1, j, m, n);
        memo[i][j] = Math.max(Math.max(Math.max(up, down), right), left) + 1;
        return memo[i][j];
    }

    public static void main(String[] args) {
        //int[][] arr = {{6, 8}, {7, 2}};
        int[][] arr = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(arr));
    }
}
