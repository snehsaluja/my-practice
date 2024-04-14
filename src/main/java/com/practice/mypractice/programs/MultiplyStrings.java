package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int[] prodArr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - 48, b, prod;
            int k = i + num2.length();
            for (int j = num2.length() - 1; j >= 0 && a != 0; j--) {
                b = num2.charAt(j) - 48;
                prod = (a * b) + prodArr[k];
                prodArr[k] = prod % 10;
                prodArr[k - 1] += prod / 10;
                k--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : prodArr) {
            if (n == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(n);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public static String multiplyBadOptimization(String num1, String num2) {
        List<StringBuilder> sbList = new ArrayList<>();
        String longNum, shortNum;
        if (num1.length() > num2.length()) {
            longNum = num1;
            shortNum = num2;
        } else {
            longNum = num2;
            shortNum = num1;
        }
        for (int i = shortNum.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < shortNum.length() - 1; j++) {
                sb.append('0');
            }
            int a = shortNum.charAt(i) - 48, b, prod, carry = 0;
            for (int j = longNum.length() - 1; j >= 0 && a != 0; j--) {
                b = longNum.charAt(j) - 48;
                prod = (a * b) + carry;
                sb.append(prod % 10);
                carry = prod / 10;
            }
            if (carry != 0)
                sb.append(carry);
            sbList.add(sb);
        }
        StringBuilder sum = sbList.get(0);
        for (int i = 1; i < sbList.size(); i++) {
            StringBuilder sb = sbList.get(i);
            sum = addStringBuilders(sb, sum);
        }
        return (sum != null && sum.length() > 0) ? sum.reverse().toString() : "0";
    }

    private static StringBuilder addStringBuilders(StringBuilder n1, StringBuilder n2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, carry = 0;
        while (i < n1.length() || j < n2.length()) {
            int a = 0, b = 0, sum;
            if (i < n1.length()) {
                a = n1.charAt(i) - 48;
                i++;
            }
            if (j < n2.length()) {
                b = n2.charAt(j) - 48;
                j++;
            }
            sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0)
            sb.append(carry);
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(multiply("9", "99"));
        System.out.println(multiply("99", "9"));
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
        System.out.println(multiply("0", "456"));
        System.out.println(multiply("123", "0"));
        System.out.println(multiply("10", "10"));
    }
}

/*

1 2
        234
        *5
        ---
        7 0*/
