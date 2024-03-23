package com.practice.mypractice.programs;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - j - 1][i];
                matrix[m - j - 1][i] = matrix[m - i - 1][n - j - 1];
                matrix[m - i - 1][n - j - 1] = matrix[i][n - i - 1];
                matrix[i][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {

    }

}
