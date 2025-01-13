package com.practice.mypractice.programs.stack;

/*
*
 Given a string "ABC#DD#E", for every # consider it as a back space. Output the final string. For example, in the above string answer will be "ABDE".
 Similarly, "A##BB#E##F" will output "F" (Use stack)

 This was extended saying if you see @ consider it as a redo, how do you implement it. For example, A#@BB#E#F will output "ABF"

* */

import java.util.Stack;

public class BackspaceFun {

    public static void main(String[] args) {

    }

    public static String readInputWithBackspace(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
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

    public static String readInputWithBackspaceAndRedo(String str) {
        Stack<Character> outputStack = new Stack<>();
        Stack<Character> deletedElements = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!outputStack.isEmpty()) {
                    deletedElements.push(outputStack.pop());
                }
            } else if (ch == '@') {
                if (!deletedElements.isEmpty()) {
                    outputStack.push(deletedElements.pop());
                }
            } else {
                outputStack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!outputStack.isEmpty()) {
            sb.append(outputStack.pop());
        }
        return sb.reverse().toString();
    }

}
