package com.practice.mypractice.programs;

public class PowerOfFour {

    public static boolean isPowerOfFour(int n) {
        if (n == 1)
            return true;
        while (n > 4 && n % 4 == 0) {
            n /= 4;
        }
        return n == 4;
    }

    public static void main(String[] args) {
        System.out.println(PowerOfFour.isPowerOfFour(64));
    }
}
