package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergingIntervals {

    public static void main(String[] args) {
        displayMergedIntervals(mergeIntervals(new int[][]{{6, 8}, {1, 9}, {2, 4}, {4, 7}}));
        displayMergedIntervals(mergeIntervals(new int[][]{{1, 2}, {1, 4}, {3, 4}, {5, 7}, {8, 9}, {11, 12}}));

        Interval[] arr = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        displayMergedIntervals2(mergeIntervals(arr));

        arr = new Interval[6];
        arr[0] = new Interval(1, 2);
        arr[1] = new Interval(1, 4);
        arr[2] = new Interval(3, 4);
        arr[3] = new Interval(5, 7);
        arr[4] = new Interval(8, 9);
        arr[5] = new Interval(11, 12);
        displayMergedIntervals2(mergeIntervals(arr));

    }

    private static void displayMergedIntervals2(List<Interval> mergeIntervals) {
        for (int i = 0; i < mergeIntervals.size(); i++) {
            Interval interval = mergeIntervals.get(i);
            System.out.println(interval.start + ", " + interval.end);
        }
        System.out.println("===============END===============");
    }

    public static List<Interval> mergeIntervals(Interval[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o.start));
        List<Interval> list = new ArrayList<>();
        list.add(arr[0]);
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            Interval interval = list.get(index);
            if (interval.end > arr[i].start) {
                interval.end = Math.max(interval.end, arr[i].end);
            } else {
                list.add(arr[i]);
                index++;
            }
        }
        return list;
    }

    private static void displayMergedIntervals(List<int[]> result) {
        for (int i = 0; i < result.size(); i++) {
            int[] interval = result.get(i);
            System.out.println(interval[0] + ", " + interval[1]);
        }
        System.out.println("===============END===============");
    }

    public static List<int[]> mergeIntervals(int[][] arr) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int[] currentInterval = arr[i];
            int[] peek = list.get(list.size() - 1);
            if (peek[1] > currentInterval[0]) {
                peek[1] = Math.max(peek[1], currentInterval[1]);
            } else {
                list.add(currentInterval);
            }
        }
        return list;
    }
}

class Interval {

    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}