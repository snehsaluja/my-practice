package com.practice.mypractice.programs;

import java.util.TreeSet;

public class ContainsDuplicate3 {
    public static void main(String[] args) {

    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        /*
        Commented Code has bad time complexity:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + indexDiff && j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }
        return false;*/
        if (nums == null || nums.length == 0 || valueDiff < 0)
            return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            Long floor = set.floor(num + valueDiff);
            if (floor != null && num - floor <= valueDiff) {
                return true;
            }
            set.add(num);
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
