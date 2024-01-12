package com.practice.mypractice.programs;

public class LargestOddNumberInString {

    public static String largestOddNumber(String num) {
        int i;
        for (i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                break;
            }
        }
        if (i >= 0) {
            return num.substring(0, i + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
        System.out.println(largestOddNumber("1234"));
        System.out.println(largestOddNumber("12345"));
    }
}
