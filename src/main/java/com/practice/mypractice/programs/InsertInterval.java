package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] output = new int[intervals.length + 1][2];
        int k = 0;
        boolean found = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!found) {
                output[k][0] = Math.min(intervals[i][0], newInterval[0]);
                if (newInterval[1] < intervals[i][0]) { // new interval should be placed in between
                    output[k][1] = newInterval[1];
                    found = true;
                } else if (newInterval[0] <= intervals[i][1] || newInterval[1] == intervals[i][1]) {     // overlapping
                    output[k][1] = Math.max(intervals[i][1], newInterval[1]);
                    found = true;
                } else {
                    output[k][1] = intervals[i][1];
                }
                k++;
            }
            if (found) {        // found
                if (intervals[i][0] <= output[k - 1][1]) {
                    output[k - 1][1] = Math.max(output[k - 1][1], intervals[i][1]);
                } else {
                    output[k][0] = intervals[i][0];
                    output[k][1] = intervals[i][1];
                    k++;
                }
            }
        }
        if (!found) {
            output[k++] = newInterval;
        }
        return Arrays.copyOf(output, k);
    }


    public static int[][] insertOptimized(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }
        int[][] output = new int[list.size()][2];
        for (int j = 0, listSize = list.size(); j < listSize; j++) {
            output[j] = list.get(j);
        }
        return output;
    }


    public static void main(String[] args) {
        test(new int[][]{{4, 6}}, new int[]{1, 2});
        test(new int[][]{{2, 6}}, new int[]{1, 2});
    }

    private static void test(int[][] intervals, int[] newInterval) {
        int[][] output = insert(intervals, newInterval);
        System.out.print("[");
        for (int i = 0; i < output.length; i++) {
            System.out.print(Arrays.toString(output[i]));
        }
        System.out.println("]");
    }


}
