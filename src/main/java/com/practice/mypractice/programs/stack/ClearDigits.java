package com.practice.mypractice.programs.stack;

import java.util.Stack;

public class ClearDigits {

    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String clearDigits2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
