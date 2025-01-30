package com.practice.mypractice.programs.dream11_leetcode;

import java.util.Stack;

public class RemoveKDigitsToMakeSmallestNumber {

    public static String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";

        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            if (!stack.isEmpty() && k > 0 && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                break;
            }
            index = i + 1;
        }

        return index < sb.length() ? sb.substring(index) : "0";
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // Output: "1219"
        System.out.println(removeKdigits("10200", 1));   // Output: "200"
        System.out.println(removeKdigits("10", 2));      // Output: "0"
        System.out.println(removeKdigits("100000", 1));      // Output: "0"
        System.out.println(removeKdigits("101000", 2));      // Output: "0"
        System.out.println(removeKdigits("1010002", 2));      // Output: "2"
    }
}
