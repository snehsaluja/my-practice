package com.practice.mypractice.programs;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println("Testing" + (-42 & 1));

        System.out.println("-------------------------");
        System.out.println(hammingWeight(1));
        System.out.println(hammingWeight(-1));
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight(80));
        System.out.println(hammingWeight(40));
        System.out.println(hammingWeight(31));
        System.out.println(hammingWeight(-31));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;

        // or simply use ---->     return Integer.bitCount(n);
    }
}
