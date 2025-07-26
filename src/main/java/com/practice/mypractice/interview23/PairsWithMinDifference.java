package com.practice.mypractice.interview23;
/*

Agoda Round 1 (28th Nov)

Given an integer array arr[] of size N, the task is to find all distinct pairs having minimum absolute difference and print them in ascending order.

Examples:

Input: arr[] = {4, 2, 1, 3}
Output: {1, 2}, {2, 3}, {3, 4}
Explanation: The minimum absolute difference between pairs is 1.


Input: arr[] = {1, 3, 8, 10, 15}
Output: {1, 3}, {8, 10}
Explanation: The minimum absolute difference between the pairs {1, 3}, {8, 10} is 2.

*/


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairsWithMinDifference {

    public static void printPairsWithMinDiff(List<Integer> numbers) {
        Collections.sort(numbers);
        List<int[]> output = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i + 1) - numbers.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                output = new ArrayList<>();
                output.add(new int[]{numbers.get(i), numbers.get(i + 1)});
            } else if (diff == minDiff) {
                output.add(new int[]{numbers.get(i), numbers.get(i + 1)});
            }
        }
        for (int[] pair : output) {
            System.out.println(pair[0] + " " + pair[1]);
        }
        System.out.println("********************************");
    }


    public static void printPairsWithMinDiff_anotherWay(List<Integer> numbers) {
        Collections.sort(numbers);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.size() - 1; i++) {
            minDiff = Math.min(minDiff, numbers.get(i + 1) - numbers.get(i));
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i + 1) - numbers.get(i);
            if (diff == minDiff) {
                System.out.println(numbers.get(i) + " " + numbers.get(i + 1));
            }
        }
        System.out.println("********************************");

    }

    public static void main(String[] args) {
        printPairsWithMinDiff(Lists.newArrayList(4, 2, 1, 3));
        printPairsWithMinDiff(Lists.newArrayList(1, 3, 8, 10, 15));
        printPairsWithMinDiff(Lists.newArrayList(6, 2, 4, 10));
        System.out.println("######################## ANOTHER WAY #################################");
        printPairsWithMinDiff_anotherWay(Lists.newArrayList(4, 2, 1, 3));
        printPairsWithMinDiff_anotherWay(Lists.newArrayList(1, 3, 8, 10, 15));
        printPairsWithMinDiff_anotherWay(Lists.newArrayList(6, 2, 4, 10));
    }

}
