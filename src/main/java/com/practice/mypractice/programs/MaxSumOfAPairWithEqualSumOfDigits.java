package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfAPairWithEqualSumOfDigits {

    public static void main(String[] args) {
        MaxSumOfAPairWithEqualSumOfDigits ob = new MaxSumOfAPairWithEqualSumOfDigits();
        System.out.println(ob.maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(ob.maximumSum(new int[]{10, 12, 19, 14}));
        System.out.println(ob.maximumSum2(new int[]{18, 43, 36, 13, 7}));
    }

    // Optimized:
    public int maximumSum2(int[] nums) {
        int n = nums.length, ans = -1;
        int[] maxArr = new int[100];
        for (int i = 0; i < n; i++) {
            int digitSum = getDigitSum(nums[i]);
            if (maxArr[digitSum] != 0) {
                int sum = nums[i] + maxArr[digitSum];
                ans = Math.max(ans, sum);
            }
            maxArr[digitSum] = Math.max(maxArr[digitSum], nums[i]);
        }
        return ans;
    }

    public int maximumSum(int[] nums) {
        int n = nums.length, max = -1;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int digitSum = getDigitSum(nums[i]);
            int[] value = map.getOrDefault(digitSum, new int[2]);
            int sum = putInMapAndGetSum(map, digitSum, value, nums[i]);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int putInMapAndGetSum(Map<Integer, int[]> map, int key, int[] value, int num) {
        if (num > value[0]) {
            value[1] = value[0];
            value[0] = num;
        } else if (num > value[1]) {
            value[1] = num;
        }
        map.put(key, value);
        return (value[1] == 0) ? -1 : value[0] + value[1];
    }

}
