package com.practice.mypractice.programs;

public class RemoveDuplicatesFromSortedArray {

    // [1,2,3,4,5,6,7,5,6,6,6,7]
    //            k           i
    public int removeDuplicates(int[] arr) {
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[k]) {
                arr[++k] = arr[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {

    }
}
