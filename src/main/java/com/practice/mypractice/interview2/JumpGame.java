package com.practice.mypractice.interview2;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length && reachable < nums.length - 1; i++) {
            if (i > reachable)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {

    }


    public boolean canJumpBADSOLUTION(int[] nums) {

        int startIdx = 0, endIdx = nums.length - 1;
        boolean canReach = true;
        if (nums.length > 0 && nums[0] >= nums.length - 1) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                canReach = false;
                endIdx = i;
                break;
            }
        }
        if (canReach) {
            return true;
        } else if (!canReach && nums.length == 1) {
            return true;
        }

        int currIdx = startIdx;
        while (currIdx <= endIdx && endIdx < nums.length) {
            while (currIdx - startIdx > nums[startIdx]) {
                startIdx++;
            }
            if ((currIdx + nums[currIdx] > endIdx) || (nums[currIdx] + (currIdx - startIdx) > endIdx)) {
                startIdx = endIdx + 1;
                currIdx = startIdx;
                endIdx = nextZeroPosition(nums, endIdx + 1);
                if (endIdx == -1) {
                    canReach = true;
                }
            } else {
                currIdx++;
            }
        }
        return canReach;
    }

    private int nextZeroPosition(int[] nums, int idx) {
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
