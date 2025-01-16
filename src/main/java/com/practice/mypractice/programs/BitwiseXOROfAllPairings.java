package com.practice.mypractice.programs;

public class BitwiseXOROfAllPairings {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int xorVal = 0;

        if (n % 2 != 0) {
            for (int i = 0; i < m; i++) {
                xorVal = xorVal ^ nums1[i];
            }
        }
        if (m % 2 != 0) {
            for (int i = 0; i < n; i++) {
                xorVal = xorVal ^ nums2[i];
            }
        }

        return xorVal;
    }

    public static void main(String[] args) {

    }
}
