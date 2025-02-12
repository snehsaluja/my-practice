package com.practice.mypractice.programs;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length, count = 1, max = 1;
        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            count = 1;
            while (i < n - 1 && nums[i] < nums[i + 1]) {
                i++;
                count++;
            }
            max = Math.max(max, count);
            count = 1;
            while (i < n - 1 && nums[i] > nums[i + 1]) {
                i++;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static int longestMonotonicSubarray2(int[] nums) {
        int n = nums.length, max = 1;
        int i = 0;
        int incLength = 1, decLength = 1;
        while (i < n - 1) {
            if (nums[i] < nums[i + 1]) {
                incLength++;
                decLength = 1;
            } else if (nums[i] > nums[i + 1]) {
                decLength++;
                incLength = 1;
            } else {
                incLength = 1;
                decLength = 1;
            }
            max = Math.max(max, Math.max(incLength, decLength));
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{1, 1, 5}));
        System.out.println(longestMonotonicSubarray(new int[]{2, 1, 10}));
    }
}
