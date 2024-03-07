package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public static int majorityElementOptimized(int[] nums) {
        /*int major = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
            }

            count += (nums[i] == major) ? 1 : -1;
        }
        return major;*/
        int ele = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ele) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    ele = nums[i];
                    count = 1;
                }
            }
        }
        return ele;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 2, 1, 2, 2, 1};
        System.out.println(majorityElementOptimized(arr));
    }
}
