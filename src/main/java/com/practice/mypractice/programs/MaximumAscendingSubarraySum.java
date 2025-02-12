package com.practice.mypractice.programs;

public class MaximumAscendingSubarraySum {

    public int maxAscendingSum(int[] nums) {
        int i = 0, n = nums.length, sum = nums[0], max = sum;
        while (i < n - 1) {
            if (nums[i] < nums[i + 1]) {
                sum += nums[i + 1];
                max = Math.max(max, sum);
            } else {
                sum = nums[i + 1];
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
