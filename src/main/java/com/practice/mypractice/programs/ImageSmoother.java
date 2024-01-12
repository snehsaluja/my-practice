package com.practice.mypractice.programs;

public class ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int arr[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = smoothen(img, i, j);
            }
        }
        return arr;
    }

    private int smoothen(int[][] img, int x, int y) {
        int m = img.length, n = img[0].length;
        int sum = 0, count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                } else {
                    sum += img[nx][ny];
                    count++;
                }
            }
        }
        return sum / count;
    }

    public static void main(String[] args) {

    }
}
