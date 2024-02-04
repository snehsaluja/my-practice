package com.practice.mypractice.programs;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {
        if (nums.length % 3 != 0) {
            return new int[0][];
        }
        Arrays.sort(nums);
        int[][] answer = new int[nums.length / 3][];
        int row = 0;
        for (int i = 0; i < nums.length - 2; i = i + 3) {
            if (nums[i + 2] - nums[i] <= k) {
                answer[row++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            } else {
                return new int[0][];
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
