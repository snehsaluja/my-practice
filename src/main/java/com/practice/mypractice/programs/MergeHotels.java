package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeHotels {

    // Merge hotels if they overlap or (end of i-th = start_of_next + 1)
    public static List<int[]> mergeHotels(int[][] hotels) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(hotels, (a, b) -> a[0] - b[0]);
        list.add(hotels[0]);
        int index = 0;
        for (int i = 1; i < hotels.length; i++) {
            int[] curr = list.get(index);
            if (hotels[i][0] <= curr[1] + 1) {
                curr[1] = Math.max(hotels[i][1], curr[1]);
            } else {
                list.add(hotels[i]);
                index++;
            }
        }
        return list;
    }

    // Merge hotels only if end of i-th = start_of_next + 1)
    public static List<int[]> mergeHotels2(int[][] hotels) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(hotels, (a, b) -> a[0] - b[0]);
        list.add(hotels[0]);
        int index = 0;
        for (int i = 1; i < hotels.length; i++) {
            int[] curr = list.get(index);
            if (hotels[i][0] == curr[1] + 1) {
                curr[1] = Math.max(hotels[i][1], curr[1]);
            } else {
                list.add(hotels[i]);
                index++;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println("Testing 1st Method::::::");
        testMergeHotels(new int[][]{{1, 3}, {7, 9}, {3, 6}});
        testMergeHotels(new int[][]{{1, 3}, {7, 9}, {10, 15}, {3, 6}, {17, 19}});
        testMergeHotels(new int[][]{{1, 3}, {4, 6}, {8, 9}, {10, 15}, {17, 19}});
        System.out.println("************************************************");
        System.out.println("Testing 2nd Method::::::");
        testMergeHotels2(new int[][]{{1, 3}, {3, 6}, {7, 9}});
        testMergeHotels2(new int[][]{{1, 3}, {3, 6}, {7, 9}, {10, 15}, {17, 19}});
        testMergeHotels2(new int[][]{{1, 3}, {4, 6}, {8, 9}, {10, 15}, {17, 19}});
    }

    private static void testMergeHotels2(int[][] arr) {
        List<int[]> output = mergeHotels2(arr);
        for (int[] o : output) {
            System.out.print(Arrays.toString(o) + "\t");
        }
        System.out.println();
    }

    private static void testMergeHotels(int[][] arr) {
        List<int[]> output = mergeHotels(arr);
        for (int[] o : output) {
            System.out.print(Arrays.toString(o) + "\t");
        }
        System.out.println();
    }
}
