package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndices {

    public static void main(String[] args) {

    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanTarget = 0, eqToTarget = 0;
        for (int num : nums) {
            if (num < target) {
                lessThanTarget++;
            } else if (num == target) {
                eqToTarget++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = lessThanTarget; i < lessThanTarget + eqToTarget; i++) {
            result.add(i);
        }
        return result;
    }

    public List<Integer> targetIndicesLowPerformance(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            } else if (nums[i] > target)
                break;
        }
        return result;
    }
}
