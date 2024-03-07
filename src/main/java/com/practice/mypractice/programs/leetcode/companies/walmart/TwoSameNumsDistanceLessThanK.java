package com.practice.mypractice.programs.leetcode.companies.walmart;

import java.util.HashMap;
import java.util.Map;

// Wallmart question from Leetcode

public class TwoSameNumsDistanceLessThanK {

    public static void main(String[] args) {
        System.out.println(isDistanceLessThanK(new int[]{1, 2, 3, 1}, 3));             // => true
        System.out.println(isDistanceLessThanK(new int[]{1, 0, 1, 1}, 1));             // => true
        System.out.println(isDistanceLessThanK(new int[]{1, 2, 3, 1, 2, 3}, 2));         // => false
    }

    public static boolean isDistanceLessThanK(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int prevOccurrence = map.getOrDefault(arr[i], -1);
            if (prevOccurrence != -1 && (i - prevOccurrence) <= k) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }
}
