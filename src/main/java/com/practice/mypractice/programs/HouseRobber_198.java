package com.practice.mypractice.programs;

public class HouseRobber_198 {

    public int robOptimized(int[] nums) {

        int rob = 0, noRob = 0;
        for (int i = 0; i < nums.length; i++) {
            int newRob = noRob + nums[i];
            int newNoRob = Math.max(rob, noRob);
            rob = newRob;
            noRob = newNoRob;
        }
        return Math.max(rob, noRob);
    }

    //  2,7,9,3,1,4,7,3,8,2,6,9,3,1
    //  rob = 10
    //  norob = 11
    //  newRob = 10
    //  newnorob = 11

    public int rob(int[] nums) {

        return rob(nums, 0, nums.length);
    }

    private int rob(int[] arr, int i, int n) {
        if (i < n) {
            return Math.max(rob(arr, i + 1, n), arr[i] + rob(arr, i + 2, n));
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
