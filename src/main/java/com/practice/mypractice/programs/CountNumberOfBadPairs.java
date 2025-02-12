package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {

    // Good Pairs :
    // nums[j] - nums[i] = j-i
    // Rewrite:
    // (nums[j] - j) = (nums[i] - i)

    // Hence, bad pairs = (total pairs - good pairs)


    public long countBadPairs2(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            totalPairs -= map.merge(diff, 1L, Long::sum) - 1;
        }
        return totalPairs;
    }

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            totalPairs -= map.getOrDefault(diff, 0L);
            map.put(diff, map.getOrDefault(diff, 0L) + 1);
        }
        return totalPairs;
    }

    public static void main(String[] args) {

    }
}
