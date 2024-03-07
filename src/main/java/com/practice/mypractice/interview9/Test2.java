package com.practice.mypractice.interview9;

/*

Walmart Round 1:

There is an integer array nums sorted in ascending order (with distinct values).

        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

        You must write an algorithm with O(log n) runtime complexity.

        Example 1:

        Input: nums = [4,5,6,7,8,0,1,2], target = 0
        Output: 4
        Example 2:

        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1
        Example 3:

        Input: nums = [1], target = 0
        Output: -1

        [1,2,3,4,5,6,7] pivot = 3, target = 3
        [4,5,6,7,1,2,3]

        [1,2,3,4,5,6,7] pivot = 2
        [3,4,5,6,7,1,2]


        [8,9,0,1,2,3,4,5,6,7] target = 9
        [8,9,0,1,2] target = 9
        [8,9] target = 9


        Input: nums = [4,5,6,7,8,0,1,2], target = 0
        Input: nums = [8,0,1,2], target = 0
*/

public class Test2 {

    public static void main(String[] args) {

    }

    public int binarySearchInRotatedArray(int[] arr, int target) {

        int low = 0, high = arr.length - 1, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] < arr[mid]) {                  // this means left side is normal sequence

                if (target < arr[mid] && target > arr[low]) {
                    // search here - right hand
                } else {
                    // search left hand side
                }

            } else if (arr[high] > arr[mid]) {          // this means right side is normal sequence
                if (target > arr[mid] && target < arr[high]) {
                    // search the right hand side
                } else {
                    // search the left hand side
                }
            }
        }

        return -1;
    }
}
