package com.practice.mypractice.programs;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        return findRec(nums, target, 0, 0, 0);
    }

    private int findRec(int[] nums, int target, int i, int sum, int count) {
        if (i == nums.length) {
            if (sum == target)
                return 1;
            else
                return 0;
        }
        int addCount = findRec(nums, target, i + 1, sum + nums[i], count);
        int subCount = findRec(nums, target, i + 1, sum - nums[i], count);
        count = count + addCount + subCount;
        return count;
    }

    public static void main(String[] args) {
        TargetSum ob = new TargetSum();
        System.out.println(ob.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
