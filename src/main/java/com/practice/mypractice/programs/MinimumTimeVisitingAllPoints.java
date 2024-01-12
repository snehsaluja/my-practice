package com.practice.mypractice.programs;

public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int[] pointA = arr[i], pointB = arr[i + 1];
            int diffX = Math.abs(pointA[0] - pointB[0]), diffY = Math.abs(pointA[1] - pointB[1]);
            int max = Math.max(diffX, diffY);
            result += max;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
