package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfSquareNumbers {

    public static void main(String[] args) {
        SumOfSquareNumbers obj = new SumOfSquareNumbers();
        System.out.println(obj.judgeSquareSum(2147483600));  // Expected output: true
        System.out.println(obj.judgeSquareSum(5));  // Expected output: true
        System.out.println(obj.judgeSquareSum(3));  // Expected output: false
        System.out.println(obj.judgeSquareSum(4));  // Expected output: true
        System.out.println(obj.judgeSquareSum(2));  // Expected output: true
        System.out.println(obj.judgeSquareSum(1));  // Expected output: true
        System.out.println(obj.judgeSquareSum(0));  // Expected output: true
        System.out.println(obj.judgeSquareSum(1000000));  // Expected output: true
        System.out.println(obj.judgeSquareSum(1000000000));  // Expected output: true
        System.out.println(obj.judgeSquareSum(1000000001));  // Expected output: false
    }

    public boolean judgeSquareSum(int c) {
        long b = (int) Math.ceil(Math.sqrt(c));
        long a = 0;
        while (a <= b) {
            long val = a * a + b * b;
            if (val == c) {
                return true;
            }
            if (val < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }

    // Bad Time complexity :
    public boolean judgeSquareSum0(int c) {
        int sqrt = (int) Math.sqrt(c);
        Set<Integer> map = new HashSet<>();
        for (int i = 1; i <= sqrt; i++) {
            int sq = i * i;
            if (map.contains(c - sq) || (sq + sq == c)) {
                return true;
            }
            map.add(i * i);
        }
        return false;
    }

}
