package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        // Time Limit Exceeded!
        long maxSum = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();
            long sum = 0;
            int j;
            for (j = i; j < i + k; j++) {
                if (!set.contains(nums[j])) {
                    sum += nums[j];
                    set.add(nums[j]);
                } else {
                    break;
                }
            }
            if (j == i + k)
                maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public long maximumSubarraySumOptimized(int[] nums, int k) {
        long maxSum = 0, currSum = 0;
        int begin = 0;

        Set<Integer> set = new HashSet<>();
        for (int end = 0; end < nums.length; end++) {
            if (!set.contains(nums[end])) {
                currSum += nums[end];
                set.add(nums[end]);

                if (end - begin + 1 == k) {
                    maxSum = Math.max(maxSum, currSum);
                    currSum -= nums[begin];
                    set.remove(nums[begin]);
                    begin++;
                }
            } else {
                while (nums[begin] != nums[end]) {
                    currSum -= nums[begin];
                    set.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }

        return maxSum;
    }

}
