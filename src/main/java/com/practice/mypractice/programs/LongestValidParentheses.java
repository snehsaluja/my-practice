package com.practice.mypractice.programs;

import java.util.Stack;

public class LongestValidParentheses {


    // ((()))

    public int longestValidParentheses(String s) {
        int maxLen = 0, count = 0, start = 0, end = 0;
        Stack<Integer> stack = new Stack<>();

        //enter -1 in stack

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    int l = stack.isEmpty() ? start : stack.peek() + 1;
                    maxLen = Math.max(maxLen, i - l + 1);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "()(()";
    }
}
