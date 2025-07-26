package com.practice.mypractice.programs;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, maxSum = 0, left = 0, right = 0;
        while (right < nums.length) {
            if (!set.contains(nums[right])) {
                sum += nums[right];
                set.add(nums[right]);
            } else {
                while (left < right) {
                    if (nums[left] == nums[right]) {
                        left++;
                        break;
                    } else {
                        sum -= nums[left];
                        set.remove(nums[left++]);
                    }
                }
            }
            right++;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int maximumUniqueSubarray_3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, maxSum = 0, left = 0, right = 0;
        while (right < nums.length) {
            if (!set.contains(nums[right])) {
                sum += nums[right];
                set.add(nums[right]);
            } else {
                while (left < right && nums[left] != nums[right]) {
                    sum -= nums[left];
                    set.remove(nums[left++]);
                }
                left++;
            }
            right++;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // 4,1,3,2,4,1,4

    public static int maximumUniqueSubarray_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, maxSum = 0, left = 0, right = 0;

        while (right < nums.length) {
            while (!set.add(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
            right++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }
}
