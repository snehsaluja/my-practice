package com.practice.mypractice.programs;

public class Largest3SameDigitNumber {

    public static void main(String[] args) {

    }

    public String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                int n = num.charAt(i) - '0';
                n = n * 100 + n * 10 + n;
                if (n > max) {
                    max = n;
                }
            }
        }
        if (max == 0) {
            return "000";
        } else if (max == Integer.MIN_VALUE) {
            return "";
        }
        return Integer.toString(max);
    }

    public String largestGoodIntegerAnotherWay(String num) {
        int result = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                result = Math.max(result, num.charAt(i) - '0');
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append((char)(48 + result));
        }
        return result == -1 ? "" : builder.toString();
    }
}
