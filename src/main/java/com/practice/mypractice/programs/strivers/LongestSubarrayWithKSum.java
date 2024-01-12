package com.practice.mypractice.programs.strivers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithKSum {

    public static void main(String[] args) {
        System.out.println(getLongestKSumSubarrayLength(new int[]{-1, 1, -1, 1}, 1));
        System.out.println(getLongestKSumSubarrayLength(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 41));
        System.out.println(getLongestKSumSubarrayLength(new int[]{1, 2, 1, 2, 1}, 3));
        System.out.println("====================================================================");
        System.out.println(getKSumSubarrayCount(new int[]{-1, 1, -1, 1}, 1));
        System.out.println(getKSumSubarrayCount(new int[]{-1, 1, -1, 1}, 0));
        System.out.println(getKSumSubarrayCount(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 41));
        System.out.println(getKSumSubarrayCount(new int[]{1, 2, 1, 2, 1}, 3));
    }

    public static int getLongestKSumSubarrayLength(int[] arr, int k) {
        int maxLen = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum - k)) {
                maxLen = Math.max((i - map.get(sum - k)), maxLen);
            } else if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }


    public static int getKSumSubarrayCount(int[] arr, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
