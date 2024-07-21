package com.practice.mypractice.programs;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{8,6,9,7,3,2,5,7,9,0,2,1,3,6,3}));
        System.out.println(missingNumber(new int[]{8,6,9,7,3,2,4,5,7,9,0,2,1,3,6,4,3}));
        System.out.println(missingNumber(new int[]{8,6,9,7,3,2,5,7,9,10,5,12,2,1,3,6,3,4}));
        System.out.println(missingNumber(new int[]{8,6,9,7,3,2,5,7,9,0,4,11,2,1,3,6,3,10}));
    }

    public static int missingNumber(int arr[]) {
        Arrays.sort(arr);
        int output = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] == output) {
                output++;
            } else if (arr[i] > output) {
                break;
            }
        }
        return output;
    }
}
