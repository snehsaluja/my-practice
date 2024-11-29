package com.practice.mypractice.programs;

// Agoda from Leetcode Discussion

public class NumberCodeConverter {

    public static String numberToCode(int num) {

        if (num > 0 && num < 191) {
            char x = (char) (((num - 1) / 10) + 'A');
            char y = (char) (((num - 1) % 10) + '0');
            return new String(new char[]{x, y});
        }

        return "Invalid Input = " + num;
    }


    public static int codeToNumber(String code) {

        if (code.length() != 2 || !(code.charAt(0) >= 'A' && code.charAt(0) <= 'S') || !(code.charAt(1) >= '0' && code.charAt(1) <= '9'))
            return -1;

        int x = (code.charAt(0) - 'A') + ((code.charAt(1) - '0') + 1) / 10;
        int y = ((code.charAt(1) - '0') + 1) % 10;
        return 10 * x + y;
    }

    public static void main(String[] args) {
        System.out.println(numberToCode(190));
        System.out.println(numberToCode(1));
        System.out.println(numberToCode(2));
        System.out.println(numberToCode(3));
        System.out.println(numberToCode(10));
        System.out.println(numberToCode(11));
        System.out.println(numberToCode(12));
        System.out.println(numberToCode(13));
        System.out.println(numberToCode(100));
        System.out.println("******");
        System.out.println(codeToNumber("S9"));
        System.out.println(codeToNumber("A0"));
        System.out.println(codeToNumber("A1"));
        System.out.println(codeToNumber("A2"));
        System.out.println(codeToNumber("A9"));
        System.out.println(codeToNumber("B0"));
        System.out.println(codeToNumber("B1"));
        System.out.println(codeToNumber("B2"));
        System.out.println(codeToNumber("J9"));
    }

}
