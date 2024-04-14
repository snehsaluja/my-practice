package com.practice.mypractice.programs;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int maxDepth = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (ch == ')') {
                stack.pop();
            }
        }
        return maxDepth;
    }

    public int maxDepthOptimized(String s) {
        int maxDepth = 0, count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                maxDepth = Math.max(maxDepth, count);
            } else if (ch == ')') {
                count--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {

    }
}
