package com.practice.mypractice.programs;

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {

    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxLen = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {

            while (nums[right] - nums[left] > (2 * k)) {
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public int maximumBeauty3(int[] nums, int k) {
        if (nums.length == 1)
            return 1;

        int maxBeauty = 0, maxVal = 0;
        for (int n : nums) {
            maxVal = Math.max(maxVal, n);
        }
        int[] arr = new int[maxVal + 1];

        for (int n : nums) {
            arr[Math.max(n - k, 0)]++;
            arr[Math.min(n + k + 1, maxVal)]--;
        }
        int currSum = 0;
        for (int n : arr) {
            currSum += n;
            maxBeauty = Math.max(maxBeauty, currSum);
        }
        return maxBeauty;
    }

    public int maximumBeauty2(int[] nums, int k) {
        if (nums.length == 1)
            return 1;

        int maxBeauty = 0;
        int maxValue = 0;

        for (int num : nums)
            maxValue = Math.max(maxValue, num);

        int[] count = new int[maxValue + 1];

        for (int num : nums) {
            count[Math.max(num - k, 0)]++;
            count[Math.min(num + k + 1, maxValue)]--;
        }

        int currentSum = 0;

        for (int val : count) {
            currentSum += val;
            maxBeauty = Math.max(maxBeauty, currentSum);
        }

        return maxBeauty;
    }

    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4, 6, 1, 2}, 2));
    }
}
