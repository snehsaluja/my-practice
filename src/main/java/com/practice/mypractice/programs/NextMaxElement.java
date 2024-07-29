package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.Stack;

public class NextMaxElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(testSolution(new int[]{4, 35, 2, 25, 26, 48})));
        System.out.println(Arrays.toString(testSolution(new int[]{4, 35, 2, 25, 26})));
        System.out.println(Arrays.toString(testSolution(new int[]{4, 5, 2, 25, 26})));
    }

    public static int[] testSolution(int[] arr) {
        //return nextMaxArrayBruteForce(arr);
        return nextMaxArray(arr);
    }

    private static int[] nextMaxArray(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        int[] output = new int[arr.length];
        Arrays.fill(output, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[stack.peek()]) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    output[stack.pop()] = arr[i];
                }
            }
            stack.push(i);

        }
        return output;
    }

    public static int[] nextMaxArrayBruteForce(int[] arr) {
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    break;
                }
            }
            if (max != arr[i]) {
                output[i] = max;
            } else {
                output[i] = -1;
            }
        }
        return output;
    }

    // input =  [4,5,2,25,26]
    //          [4,5,5,25,26]
    // output = [5,25,25,26,-1]


    // [4, 35, 2,  25, 26, 48]
    // [4, 35, 35, 35, 35, 48]
    // [35, 48, 25, 26, 48, -1]
}
