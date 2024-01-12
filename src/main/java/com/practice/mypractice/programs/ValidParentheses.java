package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

    static final Set<Character> startParenthesis = new HashSet<>();
    static final Map<Character, Character> endParenthesis = new HashMap<>();

    static {
        startParenthesis.add('{');
        endParenthesis.put('}', '{');
        startParenthesis.add('(');
        endParenthesis.put(')', '(');
        startParenthesis.add('[');
        endParenthesis.put(']', '[');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (startParenthesis.contains(ch)) {
                stack.push(ch);
            } else if (endParenthesis.containsKey(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop != endParenthesis.get(ch)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> endParenthesisMap = new HashMap<>();
        endParenthesisMap.put('}', '{');
        endParenthesisMap.put(')', '(');
        endParenthesisMap.put(']', '[');
        for (char ch : s.toCharArray()) {
            if (!endParenthesisMap.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || stack.pop() != endParenthesisMap.get(ch)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("]"));
        System.out.println(isValid("[{()()}{()}]"));
        System.out.println(isValid("[{()()}{()}}"));
        System.out.println(isValid("[{()(}}{()}]"));

        System.out.println("=========");

        System.out.println(isValid2("()"));
        System.out.println(isValid2("()[]{}"));
        System.out.println(isValid2("(]"));
        System.out.println(isValid2("]"));
        System.out.println(isValid2("[{()()}{()}]"));
        System.out.println(isValid2("[{()()}{()}}"));
        System.out.println(isValid2("[{()(}}{()}]"));
    }
}
