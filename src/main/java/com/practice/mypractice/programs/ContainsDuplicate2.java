package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = map.getOrDefault(nums[i], -1);
            if (idx != -1 && Math.abs(i - idx) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
