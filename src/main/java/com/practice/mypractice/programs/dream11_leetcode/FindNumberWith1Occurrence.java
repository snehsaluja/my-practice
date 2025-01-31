package com.practice.mypractice.programs.dream11_leetcode;

import java.util.Arrays;

// Given an array where 1 number appears once and remaining elements occur thrice.
// Identify the number occurring once

public class FindNumberWith1Occurrence {

    public static int findNumber(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                return arr[n - 1];
            }
            if (arr[i] == arr[i + 1]) {
                i += 2;
            } else {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{3, 4, 3, 4, 3, 4, 6, 5, 6, 5, 6, 7, 8, 5, 7, 8, 7, 8, 1}));             // = 1
        System.out.println(findNumber(new int[]{3, 4, 3, 4, 3, 4, 6, 5, 6, 5, 6, 7, 8, 5, 7, 8, 7, 8, 1, 1, 1, 9}));    // = 9
        System.out.println(findNumber(new int[]{3, 4, 3, 4, 3, 4, 6, 5, 5, 7, 8, 5, 7, 8, 7, 8, 1, 1, 1, 9}));          // = 6
    }
}
