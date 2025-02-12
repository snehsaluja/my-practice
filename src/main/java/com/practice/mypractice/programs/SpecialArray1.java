package com.practice.mypractice.programs;

public class SpecialArray1 {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (!((nums[i] % 2 == 0 && nums[i + 1] % 2 != 0) || (nums[i] % 2 != 0 && nums[i + 1] % 2 == 0))) {
                return false;
            }
        }
        return true;
    }

    public boolean isArraySpecial_optimized(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if ((nums[i - 1] % 2 == nums[i] % 2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
