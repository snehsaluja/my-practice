package com.practice.mypractice.programs;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    public static void main(String[] args) {

    }

    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] = matrix[i - 1][j] + 1; //     or      matrix[i][j] += matrix[i - 1][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; j--, k++) {
                max = Math.max(max, row[j] * k);        // row[j] * k is the area
            }
        }

        return max;
    }
}
