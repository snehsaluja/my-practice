package com.practice.mypractice.programs;

public class SpecialPositionBinaryMatrix {


    public int numSpecialOptimized(int[][] arr) {
        int count = 0, m = arr.length, n = arr[0].length;
        for (int i = 0; i < m; i++) {
            int col = checkForRow(arr, i);
            if (col >= 0) {
                boolean specialPresent = checkForCol(arr, i, col);
                if (specialPresent)
                    count++;
            }
        }
        return count;
    }

    private boolean checkForCol(int[][] arr, int row, int col) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] == 1 && i != row) {
                return false;
            }
        }
        return true;
    }

    private int checkForRow(int[][] arr, int row) {
        int col = -1;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[row][i] == 1) {
                if (col >= 0) {
                    return -1;
                }
                col = i;
            }
        }
        return col;
    }


    public int numSpecial(int[][] mat) {
        int count = 0, m = mat.length, n = mat[0].length;
        int[] sumRow = new int[m], sumCol = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumRow[i] += mat[i][j];
                sumCol[j] += mat[i][j];
            }
        }

        outer:
        for (int i = 0; i < m; i++) {
            if (sumRow[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (sumCol[j] == 1 && mat[i][j] == 1) {
                        count++;
                        continue outer;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
