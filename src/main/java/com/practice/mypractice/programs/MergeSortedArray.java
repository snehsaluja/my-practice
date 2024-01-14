package com.practice.mypractice.programs;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int[] ans = new int[m + n];
        int j = 0, k = 0;
        for (int i = 0; i < m + n; i++) {
            if ((j < m && k < n && arr1[j] <= arr2[k]) || (k == n && j < m)) {
                ans[i] = arr1[j];
                j++;
            } else if ((j < m && k < n && arr1[j] > arr2[k]) || (j == m && k < n)) {
                ans[i] = arr2[k];
                k++;
            }
        }
        for (int i = 0; i < m + n; i++) {
            arr1[i] = ans[i];
        }
    }

    public static void mergeApproach2(int[] arr1, int m, int[] arr2, int n) {
        int j = m - 1, k = n - 1, i;
        for (i = m + n - 1; i >= 0 && j >= 0 && k >= 0; i--) {
            if (arr1[j] <= arr2[k]) {
                arr1[i] = arr2[k];
                k--;
            } else {
                arr1[i] = arr1[j];
                j--;
            }
        }

        while (i >= 0 && k >= 0) {
            arr1[i--] = arr2[k--];
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 0, 0, 0};
        int arr2[] = {2, 5, 6};
        mergeApproach2(arr1, arr1.length - arr2.length, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));

         arr1 = new int[]{1, 2, 3, 0, 0, 0};
         arr2 = new int[]{2, 5, 6};
        merge(arr1, arr1.length - arr2.length, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));

        arr1 = new int[]{1, 2, 3, 0, 0, 0};
        arr2 = new int[]{4, 5, 6};
        mergeApproach2(arr1, arr1.length - arr2.length, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));

        arr1 = new int[]{1, 2, 3, 0, 0, 0};
        arr2 = new int[]{4, 5, 6};
        merge(arr1, arr1.length - arr2.length, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));

        arr1 = new int[]{4, 5, 6, 0, 0, 0};
        arr2 = new int[]{1, 2, 3};
        mergeApproach2(arr1, arr1.length - arr2.length, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));

        arr1 = new int[]{4, 5, 6, 0, 0, 0};
        arr2 = new int[]{1, 2, 3};
        merge(arr1, arr1.length - arr2.length, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));
    }
}
