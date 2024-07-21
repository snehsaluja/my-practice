package com.practice.mypractice.programs;

import java.util.Arrays;

// Question : https://leetcode.com/discuss/interview-question/3357573/Cross-the-Threshold-or-OA

public class CrossTheThreshold {
    public static void main(String[] args) {
        int[] initialEnergy = {4, 8, 7, 1, 2};
        int th = 9;
        System.out.println(getMaxBarrier(initialEnergy, th));
        System.out.println(getMaxBarrier(new int[]{5,2,13,10}, 8));
    }

    public static int getMaxBarrier(int[] initialEnergy, long th) {
        int left = 0;
        int right = Arrays.stream(initialEnergy).max().orElse(0);
        //int right = initialEnergy.stream().mapToInt(Integer::intValue).max().orElse(0);
        int maxBarrier = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = getFinalEnergySum(initialEnergy, mid);

            if (sum >= th) {
                maxBarrier = mid;  // mid is a valid barrier, but there might be a higher one
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxBarrier;
    }

    private static int getFinalEnergySum(int[] initialEnergy, int barrier) {
        int sum = 0;
        for (int energy : initialEnergy) {
            sum += Math.max(energy - barrier, 0);
        }
        return sum;
    }


}
