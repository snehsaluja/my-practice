package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {


    public static int maxSubarrayLength(int[] nums, int k) {
        int start = 0, end = 0, count = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < nums.length && start <= end) {
            int num = nums[end];
            map.put(num, map.getOrDefault(num, 0) + 1);
            count++;
            if (map.get(num) > k) {
                while (start <= end && map.get(num) != k) {
                    count--;
                    int s = nums[start];
                    map.put(s, map.get(s) - 1);
                    start++;
                }
            }
            maxLen = Math.max(count, maxLen);
            end++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{2, 2, 3}, 1));
        System.out.println(maxSubarrayLength(new int[]{1, 4, 4, 3}, 1));
    }

}
