package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency2 {

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i]) > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));
        System.out.println(maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 1));
        System.out.println(maxSubarrayLength(new int[]{5,5,5,5,5,5,5}, 4));
    }
}
