package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> matrixMap = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixMap.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] rowPaintCount = new int[m];
        int[] colPaintCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int[] coordinates = matrixMap.get(arr[i]);
            int x = coordinates[0], y = coordinates[1];
            rowPaintCount[x]++;
            colPaintCount[y]++;
            if (rowPaintCount[x] == n || colPaintCount[y] == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
