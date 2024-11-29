package com.practice.mypractice.programs;

public class BinarySearchInRotatedArray {

    public static int binarySearchInRotatedArray(int[] arr, int target) {

        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            // or int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[low] <= arr[mid]) {     // left side is sorted
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {    // right side is sorted
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearchInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(binarySearchInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(binarySearchInRotatedArray(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 3));
        System.out.println(binarySearchInRotatedArray(new int[]{1}, 0));
    }
}
