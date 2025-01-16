package com.practice.mypractice.programs;

import java.util.BitSet;

public class MinimizeXor {

    public static int minimizeXor(int num1, int num2) {
        int setBits = Integer.bitCount(num2);
        int bits = 31;
        int x = 0;

        while (bits >= 0 && setBits > 0) {
            if ((num1 & (1 << bits)) != 0) {  // i.e. a 1 is present at index 'bits' in num1
                x = x | (1 << bits);          // set 1 at index 'bits' in x;
                setBits--;
            }
            bits--;
        }
        bits = 0;
        while (setBits > 0 && bits <= 31) {
            if ((num1 & (1 << bits)) == 0) {
                x = x | (1 << bits);          // set 1 at index 'bits' in x;
                setBits--;
            }
            bits++;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(31));
        System.out.println(minimizeXor(99, 63));
    }
}
