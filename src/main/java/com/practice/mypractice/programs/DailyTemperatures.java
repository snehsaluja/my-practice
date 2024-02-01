package com.practice.mypractice.programs;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int num = temperatures[i], j;
            for (j = i + 1; j < temperatures.length && temperatures[j] > num; j++) {

            }
            result[i] = (j == temperatures.length) ? 0 : j - i - 1;
        }

        return result;
    }

    public int[] dailyTemperaturesOptimized(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);

        }
        return result;
    }

    public static void main(String[] args) {

    }

}
