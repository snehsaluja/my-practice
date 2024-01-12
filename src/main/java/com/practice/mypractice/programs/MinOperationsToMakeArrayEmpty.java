package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinOperationsToMakeArrayEmpty {

    public static void main(String[] args) {

    }

    public int minOperations(int[] nums) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == 1) {
                return -1;
            }
            count += val / 3;
            val = val % 3;
            count += (val > 0) ? 1 : 0;
        }
        return count;
    }

    public int minOperationsOptimized(int[] nums) {
        Arrays.sort(nums);
        int current, count, result = 0;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            count = 0;
            while (i < nums.length && current == nums[i]) {
                count++;
                i++;
            }
            if (count == 1) return -1;
            result += count / 3.0;
            count = count % 3;
            result += (count > 0) ? 1 : 0;
            i--;
        }
        return result;
    }

}
