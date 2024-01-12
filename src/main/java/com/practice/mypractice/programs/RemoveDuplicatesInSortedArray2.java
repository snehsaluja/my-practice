package com.practice.mypractice.programs;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray2 {

    public int removeDuplicates(int[] nums) {
        int result = nums.length, current, count, startIndex;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            startIndex = i;
            count = 0;
            while (i < nums.length && nums[i] == current) {
                count++;
                i++;
            }
            if (count > 2) {
                for (int j = startIndex + 2; j < i; j++) {
                    nums[j] = Integer.MAX_VALUE;
                }
                result -= (count - 2);
            }
            i--;
        }
        Arrays.sort(nums);
        return result;
    }

    public int removeDuplicatesOptimized(int[] arr) {
        int k = 2;
        if (arr.length <= 2) {
            return arr.length;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != arr[k - 2]) {
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {

    }
}
