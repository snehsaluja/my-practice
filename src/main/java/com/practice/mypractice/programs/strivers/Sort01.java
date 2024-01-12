package com.practice.mypractice.programs.strivers;

import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int[] arr1 = {1, 0, 1, 1, 1, 0};
        sortColors(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 0, 1};
        sortColors(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {0};
        sortColors(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1, 1, 1, 0, 0, 1, 1, 0};
        sortColors(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    public static void sortColors(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            while (arr[low] == 0 && low < high) {
                low++;
            }
            while (arr[high] == 1 && low < high) {
                high--;
            }
            swap(arr, low, high);
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
