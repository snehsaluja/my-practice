package com.practice.mypractice.programs;

/*
Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:
Input: num1 = "0", num2 = "0"
Output: "0"
*/


public class AddStrings {

    public static void main(String[] args) {
        String num1 = "11111111", num2 = "2222212311";
        AddStrings mathematics = new AddStrings();
        String sum = mathematics.addStrings(num1, num2);
        //DecimalFormat df = new DecimalFormat("##,##,##0");
        //String formatted = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(Integer.parseInt(sum));
        String formattedString = mathematics.formatIndianConvention(sum);
        System.out.println(num1 + " + " + num2 + " = " + sum);
        System.out.println(num1 + " + " + num2 + " = " + formattedString);
    }

    private String formatIndianConvention(String sum) {
        StringBuilder formattedString = new StringBuilder();
        int tens = 0, thous = 0;
        for (int i = sum.length() - 1; i >= 0; i--) {
            if (tens < 3) {
                formattedString.append(sum.charAt(i));
                tens++;
            } else {
                if (thous == 0) {
                    formattedString.append(',');
                }
                formattedString.append(sum.charAt(i));
                thous = (++thous) % 2;
            }
        }

        return formattedString.reverse().toString();
    }

    public String addStrings(String num1, String num2) {
        if (isEmpty(num1) || isEmpty(num2) || isInvalidNumber(num1) || isInvalidNumber(num2)) {
            throw new ArithmeticException("Invalid Numbers Provided: " + num1 + " & " + num2);
        }
        int end1 = num1.length() - 1, end2 = num2.length() - 1, carryOver = 0, digit1, digit2, k;
        StringBuilder sum = new StringBuilder();
        while (end1 >= 0 || end2 >= 0 || carryOver > 0) {
            digit1 = 0;
            digit2 = 0;
            k = 0;

            if (end1 >= 0) {
                digit1 = num1.charAt(end1) - 48;
            }
            if (end2 >= 0) {
                digit2 = num2.charAt(end2) - 48;
            }
            k = (carryOver + digit1 + digit2) % 10;
            carryOver = (carryOver + digit1 + digit2) / 10;
            sum.append(k);
            end1--;
            end2--;
        }
        return sum.reverse().toString();
    }

    public String addStringsOptimized(String num1, String num2) {
        if (isEmpty(num1) || isEmpty(num2) || isInvalidNumber(num1) || isInvalidNumber(num2)) {
            throw new ArithmeticException("Invalid Numbers Provided: " + num1 + " & " + num2);
        }
        int end1 = num1.length() - 1, end2 = num2.length() - 1, carryOver = 0, addition;
        StringBuilder sum = new StringBuilder();
        while (end1 >= 0 || end2 >= 0 || carryOver > 0) {
            addition = carryOver;

            if (end1 >= 0) {
                addition += num1.charAt(end1) - 48;
            }
            if (end2 >= 0) {
                addition += num2.charAt(end2) - 48;
            }
            carryOver = addition / 10;
            sum.append(addition % 10);
            end1--;
            end2--;
        }
        return sum.reverse().toString();
    }

    private boolean isInvalidNumber(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) >= 48 && str.charAt(i) <= 57) {
            i++;
        }
        return !(i == str.length());
    }

    private boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }
}
