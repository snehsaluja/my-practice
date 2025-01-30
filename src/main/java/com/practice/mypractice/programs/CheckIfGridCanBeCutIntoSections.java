package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CheckIfGridCanBeCutIntoSections {

    public static boolean checkValidCuts(int n, int[][] rectangles) {

        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];

        int index = 0;
        for (int[] rect : rectangles) {
            int startX = rect[0];
            int startY = rect[1];
            int endX = rect[2];
            int endY = rect[3];
            xIntervals[index] = (new int[]{startX, endX});
            yIntervals[index] = (new int[]{startY, endY});
            index++;
        }

        Arrays.sort(xIntervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(yIntervals, (a, b) -> a[0] - b[0]);
        for (int[] ints : xIntervals) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("*******");
        for (int[] ints : yIntervals) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("*******");
        List<int[]> listX = new ArrayList<>();
        listX.add(xIntervals[0]);
        int currXIndex = 0, size = xIntervals.length;
        for (int i = 1; i < size; i++) {
            int[] interval = xIntervals[i];
            int[] currX = listX.get(currXIndex);
            if (interval[0] < currX[1]) {
                //xIntervals[currXIndex][1]
                listX.get(currXIndex)[1] = Math.max(interval[1], currX[1]);
            } else {
                listX.add(interval);
                currXIndex++;
            }
        }
        List<int[]> listY = new ArrayList<>();
        listY.add(yIntervals[0]);
        int currYIndex = 0;
        size = yIntervals.length;
        for (int i = 1; i < size; i++) {
            int[] interval = yIntervals[i];
            int[] currY = listY.get(currYIndex);
            if (interval[0] < currY[1]) {
                //yIntervals[currXIndex][1] = Math.max(interval[1], currX[1]);
                listY.get(currYIndex)[1] = Math.max(interval[1], currY[1]);
            } else {
                listY.add(interval);
                currYIndex++;
            }
        }
        for (int[] ints : listX) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("========");
        for (int[] ints : listY) {
            System.out.println(Arrays.toString(ints));
        }


        //System.out.println(listY);
        return (listX.size() == 3 || listY.size() == 3);
    }

    public static void main(String[] args) {
        System.out.println(checkValidCuts(4,
                new int[][]{{0, 2, 2, 4},
                        {1, 0, 3, 2},
                        {2, 2, 3, 4},
                        {3, 0, 4, 2},
                        {3, 2, 4, 4}}));
    }
}
