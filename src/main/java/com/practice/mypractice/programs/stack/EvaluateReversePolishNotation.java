package com.practice.mypractice.programs.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            char firstChar = token.charAt(0);
            if (token.length()==1 && isOperator(firstChar)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int ans = calculate(num1, num2, firstChar);
                stack.push(ans);
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }

    private boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        System.out.println(obj.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(obj.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(obj.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
