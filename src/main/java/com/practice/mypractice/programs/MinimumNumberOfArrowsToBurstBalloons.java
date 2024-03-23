package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int count = 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
/*
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= points[i - 1][1]) {

            }
        }*/
        int k;
        for (int i = points.length - 1; i >= 0; i--) {
            count++;
            k = 1;
            while ((i - k) >= 0 && points[i][0] <= points[i - k][1]) {
                k++;
            }
            i = i - k + 1;
        }
        return count;
    }

    public int findMinArrowShots2(int[][] points) {
        int count = 1;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int prev = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= prev) {
                prev = Math.min(prev, points[i][1]);
            } else {
                count++;
                prev = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons obj = new MinimumNumberOfArrowsToBurstBalloons();
        obj.test(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        obj.test(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        obj.test(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
        obj.test2(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        obj.test2(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        obj.test2(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
    }

    private void test(int[][] points) {
        System.out.println("Input ==> ");
        System.out.println(Arrays.deepToString(points));
        System.out.println("Output ==> ");
        System.out.println(findMinArrowShots(points));
        System.out.println("============================ ");
    }

    private void test2(int[][] points) {
        System.out.println("Input ==> ");
        System.out.println(Arrays.deepToString(points));
        System.out.println("Output ==> ");
        System.out.println(findMinArrowShots2(points));
        System.out.println("============================ ");
    }
}
