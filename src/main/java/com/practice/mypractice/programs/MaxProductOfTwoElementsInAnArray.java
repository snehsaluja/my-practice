package com.practice.mypractice.programs;

public class MaxProductOfTwoElementsInAnArray {


    public int maxProduct(int[] arr) {
        int max = 0, secondMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return (max - 1) * (secondMax - 1);
    }

    public static void main(String[] args) {

    }
}
