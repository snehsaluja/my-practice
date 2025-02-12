package com.practice.mypractice.programs;

public class CheckIfArrayIsSortedAndRotated {

    public static boolean check(int[] nums) {
        int i, n = nums.length;
        for (i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                break;
            }
        }
        int j = 0;
        while (j < n - 1) {
            if (nums[(i + j) % n] > nums[(i + j + 1) % n]) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static boolean check2(int[] nums) {
        int i, n = nums.length, count = 0;
        for (i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        }
        if (nums[n - 1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
    }
}
