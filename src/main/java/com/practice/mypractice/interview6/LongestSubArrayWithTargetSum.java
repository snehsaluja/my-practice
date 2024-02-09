package com.practice.mypractice.interview6;

import java.util.HashMap;
import java.util.Map;

// epam

public class LongestSubArrayWithTargetSum {
    public static void main(String[] args) {

        // Find the length of Longest sub-array which has sum = targetSum
        int[] arr = {15, 4, -2, 2, -3, 1, 3, 3, 0}; // output = 7
        int targetSum = 4;
		/*4 ==> len 1
		4, -2, 2 ==> len 3
		-3, 1, 3, 3 ==> len 4
		-3, 1, 3, 3, 0 ==> len 5
		-2, 2, -3, 1, 3, 3, 0 ==> len 7
		1, 3 ==> len 2
        output: Max length is 7*/

        // int[] arr = {1,2,3,4,5,6,7,8}; targetSum = 3; output = 2

        System.out.println(longestSubArrayLen(arr, targetSum));

    }

    private static int longestSubArrayLen(int[] arr, int targetSum) {
        int sum = 0, maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();
        //   sum      index
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - targetSum)) {
                int index = map.get(sum - targetSum);
                if (i - index > maxLen) {
                    maxLen = i - index;
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
