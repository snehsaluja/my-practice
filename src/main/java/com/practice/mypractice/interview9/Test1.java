package com.practice.mypractice.interview9;
/*

Walmart Round 1:


Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getIndexesOfTheNumbers(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(getIndexesOfTheNumbers(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(getIndexesOfTheNumbers(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(getIndexesOfTheNumbers(new int[]{3, 3}, 9)));
    }


    public static int[] getIndexesOfTheNumbers(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(k - arr[i])) {
                return new int[]{map.get(k - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }

        return new int[]{-1, -1};
    }

}
