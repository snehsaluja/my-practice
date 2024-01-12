package com.practice.mypractice.programs;

public class DifferenceBwOnesAndZeros {

    public static void main(String[] args) {

    }

    public static int[][] onesMinusZeros(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[] rowSum = new int[m], colSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = (arr[i][j] == 1) ? 1 : -1;
                rowSum[i] += val;
                colSum[j] += val;
            }
        }

        int[][] arr2 = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr2[i][j] = rowSum[i] + colSum[j];
            }
        }
        return arr2;
    }
}
