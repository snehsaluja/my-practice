package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static void main(String[] args) {
        int nums[] = {2, 3, 11, 15, 7}, target = 9;
        TwoSums obj = new TwoSums();
        int indices[] = obj.twoSum(nums, target);
        if (indices != null) {
            System.out.println(indices[0] + " and " + indices[1]);
        } else {
            System.out.println("Not Found");
        }
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
