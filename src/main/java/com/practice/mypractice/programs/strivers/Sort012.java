package com.practice.mypractice.programs.strivers;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr1 = {2, 0, 2, 1, 1, 0};
        sortColors(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {2, 0, 1};
        sortColors(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {0};
        sortColors(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1, 1, 2, 0, 2, 1, 1, 0};
        sortColors(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (nums[left] != 2 && left < right) {
                left++;
            }
            while (nums[right] == 2 && left < right) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
                left++;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            while (nums[right] != 0 && left < right) {
                right--;
            }
            while (nums[left] == 0 && left < right) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
