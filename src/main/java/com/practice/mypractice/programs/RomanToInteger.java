package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("XI"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println("==================");
        System.out.println(romanToIntOptimized("XI"));
        System.out.println(romanToIntOptimized("IX"));
        System.out.println(romanToIntOptimized("III"));
        System.out.println(romanToIntOptimized("LVIII"));
        System.out.println(romanToIntOptimized("MCMXCIV"));
    }

    public static int romanToIntOptimized(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                result -= getValue(s.charAt(i));
            } else {
                result += getValue(s.charAt(i));
            }
        }
        return result;
    }


    public static int romanToInt(String s) {

        Map<Character, Integer> valueMap = new HashMap<>();
        populateValueMap(valueMap);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i < s.length() - 1 && valueMap.get(s.charAt(i)) < valueMap.get(s.charAt(i + 1))) {
                result -= valueMap.get(s.charAt(i));
            } else {
                result += valueMap.get(s.charAt(i));
            }
        }
        return result;
    }

    private static void populateValueMap(Map<Character, Integer> valueMap) {
        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);
    }


    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
