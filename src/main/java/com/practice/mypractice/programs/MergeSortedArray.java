package com.practice.mypractice.programs;

public class MergeSortedArray {

    public void merge(int[] arr1, int m, int[] arr2, int n) {
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

    public static void main(String[] args) {

    }
}
