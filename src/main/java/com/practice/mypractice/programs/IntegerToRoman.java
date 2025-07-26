package com.practice.mypractice.programs;

import java.util.Map;

public class IntegerToRoman {


    public static String intToRoman(int num) {

        Map<Integer, String> map = Map.of(1, "I",
                5, "V",
                10, "X",
                50, "L",
                100, "C",
                500, "D",
                1000, "M");

        StringBuilder sb = new StringBuilder();
        boolean twoFiveFlag = false;
        int div = 1000;
        while (num > 0) {
            if ((!twoFiveFlag && (div / 10) > 0 && num / (div / 10) == 9)) {
                int nextDiv = div / 10;
                sb.append(map.get(nextDiv));
                sb.append(map.get(div));
                num = num - (div * 9 / 10);
            } else if ((twoFiveFlag && num / (div / 5) == 4)) {
                int nextDiv = div / 5;
                sb.append(map.get(nextDiv));
                sb.append(map.get(div));
                num = num - (div * 4 / 5);
            } else if (num / div > 0) {
                sb.append(map.get(div));
                num -= div;
            } else {
                div = div / ((!twoFiveFlag) ? 2 : 5);
                twoFiveFlag = !twoFiveFlag;
            }
        }

        return sb.toString();
    }

    public static String intToRoman_2(int num) {

        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] nStr = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder sb = new StringBuilder();
        int index = nums.length - 1;
        while (num > 0) {
            while (num / nums[index] > 0) {
                sb.append(nStr[index]);
                num = num - nums[index];
            }
            index--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3000));
        System.out.println(intToRoman(3500));
        System.out.println(intToRoman(3400));
        System.out.println(intToRoman(3401));
        System.out.println(intToRoman(900));
    }
}
