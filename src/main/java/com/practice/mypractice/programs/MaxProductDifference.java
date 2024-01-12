package com.practice.mypractice.programs;

public class MaxProductDifference {

    public static int maxProductDifference(int[] nums) {
        int max = 0, secondMax = 0, min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }

            if (nums[i] < min) {
                secondMin = min;
                min = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        return (max * secondMax) - (min * secondMin);
    }

    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{5,6,2,7,4}));
        System.out.println(maxProductDifference(new int[]{4,2,5,9,7,4,8}));
    }
}
