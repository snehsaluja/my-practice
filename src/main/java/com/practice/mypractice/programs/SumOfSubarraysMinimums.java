package com.practice.mypractice.programs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfSubarraysMinimums {

    private static final int MOD = 1000000007;

    public static int sumSubarrayMins(int[] arr) {
        int answer = 0, min, subLen = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j + subLen < arr.length; j++) {
                min = Integer.MAX_VALUE;
                for (int k = j; k < j + subLen; k++) {
                    if (arr[k] < min) {
                        System.out.println(arr[k]);
                        min = arr[k];
                    }
                }
                answer = (answer + min) % MOD;
            }
            subLen++;
        }
        return answer;
    }

    public static int sumSubarrayMinsOptimized(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill(left, -1);
        Arrays.fill(right, length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        long answer = 0;

        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }

        return (int) answer;
    }




    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
}
