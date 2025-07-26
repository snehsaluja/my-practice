package com.practice.mypractice.programs;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {

    class StringSum {
        String remainingString;
        int sum;

        public StringSum(String remainingString, int sum) {
            this.remainingString = remainingString;
            this.sum = sum;
        }
    }

    public int maximumGain(String s, int x, int y) {
        int sumX = 0, sumY = 0;
        String copy = new String(s);
        if (x >= y) {
            StringSum ab = removeSub('a', 'b', copy, x);
            sumX = ab.sum;
            StringSum ba = removeSub('b', 'a', ab.remainingString, y);
            sumY = ba.sum;
        } else {
            StringSum ba = removeSub('b', 'a', copy, y);
            sumY = ba.sum;
            StringSum ab = removeSub('a', 'b', ba.remainingString, x);
            sumX = ab.sum;
        }
        return sumX + sumY;
    }

    private StringSum removeSub(char first, char second, String copy, int num) {
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = copy.length() - 1; i >= 0; i--) {
            char ch = copy.charAt(i);
            char prev = !stack.isEmpty() ? stack.peek() : ' ';
            if (ch == first && prev == second) {
                sum += num;
                stack.pop();
                continue;
            }
            stack.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return new StringSum(sb.toString(), sum);
    }


    public int maximumGain_2(String s, int x, int y) {
        int sum = 0;
        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbTwo = new StringBuilder();
        if (x >= y) {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'b' && sbOne.length() > 0 && sbOne.charAt(sbOne.length() - 1) == 'a') {
                    sbOne.deleteCharAt(sbOne.length() - 1);
                    sum += x;
                } else {
                    sbOne.append(ch);
                }
            }
            for (int i = 0; i < sbOne.length(); i++) {
                char ch = sbOne.charAt(i);
                if (ch == 'a' && sbTwo.length() > 0 && sbTwo.charAt(sbTwo.length() - 1) == 'b') {
                    sbTwo.deleteCharAt(sbTwo.length() - 1);
                    sum += y;
                } else {
                    sbTwo.append(ch);
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'a' && sbOne.length() > 0 && sbOne.charAt(sbOne.length() - 1) == 'b') {
                    sbOne.deleteCharAt(sbOne.length() - 1);
                    sum += y;
                } else {
                    sbOne.append(ch);
                }
            }
            for (int i = 0; i < sbOne.length(); i++) {
                char ch = sbOne.charAt(i);
                if (ch == 'b' && sbTwo.length() > 0 && sbTwo.charAt(sbTwo.length() - 1) == 'a') {
                    sbTwo.deleteCharAt(sbTwo.length() - 1);
                    sum += x;
                } else {
                    sbTwo.append(ch);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
