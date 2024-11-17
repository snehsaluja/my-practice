package com.practice.mypractice.programs;

public class FindLengthOfShortestSubArrayToRemoveToMakeArraySorted {

    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, left = 0, right = n - 1;

        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1)
            return 0;

        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        int result = Math.min(n - left - 1, right);
        int i = 0, j = right;

        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
        System.out.println(findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{2, 2, 2, 1, 1, 1}));
    }
}
