package com.practice.mypractice.programs;

import java.util.Arrays;

public class SpecialArray2 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(isArraySpecialOptimized(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}})));
        System.out.println(Arrays.toString(isArraySpecialOptimized(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] isSpecial = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            boolean even1 = nums[i] % 2 == 0;
            boolean even2 = nums[i + 1] % 2 == 0;
            isSpecial[i] = (even1 && !even2) || (!even1 && even2);
        }
        boolean[] result = new boolean[queries.length];
        Arrays.fill(result, true);
        int index = 0;
        for (int[] q : queries) {
            for (int i = q[0]; i < q[1]; i++) {
                result[index] = result[index] && isSpecial[i];
            }
            index++;
        }
        return result;
    }

    public static boolean[] isArraySpecialOptimized(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] specialFreq = new int[n];
        for (int i = 1; i < n; i++) {
            boolean even1 = nums[i - 1] % 2 == 0;
            boolean even2 = nums[i] % 2 == 0;
            specialFreq[i] = (even1 && !even2) || (!even1 && even2) ?
                    specialFreq[i - 1] + 1 : specialFreq[i];
        }
        boolean[] result = new boolean[queries.length];
        //Arrays.fill(result, true);
        int index = 0;
        for (int[] q : queries) {
            result[index] = (specialFreq[q[1]] - specialFreq[q[0]] == q[1] - q[0]);
            index++;
        }
        return result;
    }

}
