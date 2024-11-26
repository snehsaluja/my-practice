package com.practice.mypractice.programs;

public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negativeCount = 0, minAbs = Integer.MAX_VALUE, m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);
                minAbs = Math.min(minAbs, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) {
                    negativeCount++;
                }
            }
        }

        return negativeCount % 2 == 0 ? sum : sum - (2 * minAbs);
    }

    public long maxMatrixSumOptimized(int[][] matrix) {
        long sum = 0;
        int minAbs = Integer.MAX_VALUE, m = matrix.length, n = matrix[0].length;
        boolean negative = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (num < 0) {
                    num = -num;
                    negative = !negative;
                }
                sum += num;
                minAbs = Math.min(minAbs, num);
            }
        }

        return negative ? sum : sum - (2 * minAbs);
    }

    public static void main(String[] args) {

    }
}
