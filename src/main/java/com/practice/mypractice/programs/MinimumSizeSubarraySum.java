package com.practice.mypractice.programs;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] arr) {
        /*int low = 0, high = 0, minLen = Integer.MAX_VALUE, sum = 0;

        while (low < arr.length) {
            while (high < arr.length) {
                sum += arr[high++];
                if (sum >= target) {
                    if ((high - low) < minLen) {
                        minLen = (high - low);
                    }
                    break;
                }
            }
            while (low < high) {
                sum -= arr[low++];
                if (sum >= target) {
                    if ((high - low) < minLen) {
                        minLen = (high - low);
                    }
                } else {
                    break;
                }
            }
*/
        int minLen = Integer.MAX_VALUE, sum = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= target) {
                minLen = Math.min(minLen, i - j + 1);
                sum -= arr[j++];
            }
        }


        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(80, new int[]{10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}));
    }
}
