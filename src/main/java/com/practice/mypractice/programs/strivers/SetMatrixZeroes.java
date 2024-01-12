package com.practice.mypractice.programs.strivers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        // System.out.println(VM.current().details());
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        // int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(Arrays.toString(matrix[i]) + ",");
        }
        System.out.println("\b]");
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        /*
        for (int row : rows) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }
        for (int col : cols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }*/

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroesOptimized(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] rows = new boolean[n];
        boolean[] column = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || column[j])
                    matrix[i][j] = 0;
            }
        }
    }
}
