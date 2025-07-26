package com.practice.mypractice.interview23;
/*

Agoda Round 1 (28th Nov)

Given an array, print the Next Smaller Element (NSE) for every element.
The NSE for an element x is the first smaller element on the right side of x in the array.
Elements for which no smaller element exist (on the right side), consider NSE as -1.

Examples:

Input: [4, 8, 5, 2, 25]
Output: [2, 5, 2, 0, 0]
Explanation:
The first element smaller than 4 having index > 0 is 2.
The first element smaller than 8 having index > 1 is 5.
The first element smaller than 5 having index > 2 is 2.
There are no elements smaller than 4 having index > 3.
There are no elements smaller than 4 having index > 4.

Input: [13, 7, 6, 12]
Output: [7, 6, 0, 0]
Explanation:
The first element smaller than 13 having index > 0 is 7.
The first element smaller than 7 having index > 1 is 6.
There are no elements smaller than 6 having index > 2.
There are no elements smaller than 12 having index > 3.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {

    public static List<Integer> getNSE(int arr[]) {
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int outputElement = 0;
            //boolean found = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < curr) {
                    //  output.add(j - i);
                    outputElement = j - i;
                    //  found = true;
                    break;
                }
            }
            output.add(outputElement);
            /*if (!found) {
                output.add(0);
            }*/
        }
        return output;
    }

    public static int[] getNSEOptimized(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }

            //result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            result[i] = stack.isEmpty() ? 0 : arr[stack.peek()];
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        System.out.println("Below output will give the the NSE indexes from current position");
        System.out.println(getNSE(arr));
        System.out.println(getNSE(new int[]{73, 74, 75, 71, 69, 72, 76, 75, 71}));
        System.out.println(getNSE(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        System.out.println(getNSE(new int[]{4, 8, 2, 1, 6, 10, 5}));
        System.out.println("\nBelow output will give the the NSE values");
        System.out.println(Arrays.toString(getNSEOptimized(new int[]{73, 74, 75, 71, 69, 72, 76, 75, 71})));
        System.out.println(Arrays.toString(getNSEOptimized(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(getNSEOptimized(new int[]{4, 8, 2, 1, 6, 10, 5})));

    }

}
