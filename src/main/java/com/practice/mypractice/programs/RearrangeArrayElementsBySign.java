package com.practice.mypractice.programs;

public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] arr) {
        int pos = 0, neg = 1, turn = 1, n = arr.length;
        int[] output = new int[arr.length];
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                output[pos] = arr[i];
                pos += 2;
            } else {
                output[neg] = arr[i];
                neg += 2;
            }
        }
        return output;
    }

    public static void main(String[] args) {

    }
}
