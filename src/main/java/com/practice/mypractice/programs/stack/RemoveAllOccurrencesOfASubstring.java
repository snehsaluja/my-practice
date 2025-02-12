package com.practice.mypractice.programs.stack;

import java.util.Arrays;
import java.util.Stack;

public class RemoveAllOccurrencesOfASubstring {

    public String removeOccurrences(String s, String part) {
        int len = s.length(), partLen = part.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.push(s.charAt(i));
            StringBuilder temp = findPartInStack(partLen, stack);
            pushBackToStackIfApplicable(part, temp, partLen, stack);
        }
        StringBuilder sb = popReversedResult(stack);
        return sb.toString();
    }

    private static void pushBackToStackIfApplicable(String part, StringBuilder temp, int partLen, Stack<Character> stack) {
        if (temp != null && !temp.toString().equals(part)) {
            for (int j = 0; j < partLen; j++) {
                stack.push(temp.charAt(j));
            }
        }
    }

    private static StringBuilder findPartInStack(int partLen, Stack<Character> stack) {
        if (stack.size() < partLen) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int j = 0; j < partLen; j++) {
            temp.insert(0, stack.pop());
        }
        return temp;
    }

    private static StringBuilder popReversedResult(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb;
    }


    //Approach 2:
    public String removeOccurrences2(String s, String part) {
        int partLen = part.length();
        int index = s.indexOf(part);
        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + partLen);
            index = s.indexOf(part);
        }
        return s;
    }

    //Approach 3:
    public String removeOccurrences3(String s, String part) {
        int len = s.length(), partLen = part.length();
        char[] sChArr = s.toCharArray();
        char[] stack = new char[len];
        char[] partChArr = part.toCharArray();
        int stackTop = -1;

        for (int i = 0; i < len; i++) {
            stack[++stackTop] = sChArr[i];
            int j = partLen - 1, k = stackTop;
            if (stackTop >= partLen - 1) {
                while (j >= 0 && stack[k] == partChArr[j]) {
                    k--;
                    j--;
                }
                if (j < 0) {
                    stackTop = k;
                }
            }
        }
        return new String(stack, 0, stackTop + 1);
    }


    public static void main(String[] args) {
        RemoveAllOccurrencesOfASubstring ob = new RemoveAllOccurrencesOfASubstring();
        System.out.println(ob.removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(ob.removeOccurrences2("daabcbaabcbc", "abc"));
        System.out.println(ob.removeOccurrences3("daabcbaabcbc", "abc"));
    }
}
