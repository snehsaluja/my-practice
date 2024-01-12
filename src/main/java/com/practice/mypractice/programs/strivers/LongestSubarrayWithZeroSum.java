package com.practice.mypractice.programs.strivers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {

    public static void main(String[] args) {
        System.out.println(getLongestZeroSumSubarrayLength(new int[]{-1, 1, -1, 1}));
        System.out.println(getLongestZeroSumSubarrayLength(new int[]{15, -2, 2, -8, 1, 7, 10, 23}));
    }

    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        int maxLen = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum)) {
                maxLen = Math.max((i - map.get(sum)), maxLen);
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
