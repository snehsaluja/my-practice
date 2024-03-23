package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousSubArray01 {

    public static int findMaxLength(int[] nums) {
        int n = nums.length, max = 0, diff;
        int[] freq = new int[2];
        Map<Integer, Integer> diffMap = new HashMap<>();
        diffMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
            diff = freq[0] - freq[1];
            if (diffMap.containsKey(diff)) {
                max = Math.max(max, i - diffMap.get(diff));
            } else {
                diffMap.put(diff, i);
            }
        }
        return max;
    }

    public static int findMaxLengthMemoryOptimized(int[] nums) {
        int n = nums.length, max = 0, diff = 0;
        //int[] freq = new int[2];
        int[] diffMap = new int[2 * n + 1];
        Arrays.fill(diffMap, Integer.MIN_VALUE);
        diffMap[n] = -1;
        for (int i = 0; i < n; i++) {
            //freq[nums[i]]++;
            // diff = freq[0] - freq[1];
            diff += (nums[i] == 0 ? 1 : -1);
            if (diffMap[n + diff] != Integer.MIN_VALUE) {
                max = Math.max(max, i - diffMap[n + diff]);
            } else {
                diffMap[n + diff] = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(findMaxLength(new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1,
                0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1,
                1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0,
                1, 1, 0, 0, 0, 1, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 1}));
        System.out.println(findMaxLengthMemoryOptimized(new int[]{0, 0, 1}));
    }
}
