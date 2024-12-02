package com.practice.mypractice.programs;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));               // true
        System.out.println(checkIfExist(new int[]{3, 1, 7, 11}));               // false
        System.out.println(checkIfExist(new int[]{7, 1, 14, 11}));              // true
        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));  // false
        System.out.println(checkIfExist(new int[]{0, 0}));                      // true
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2))
                return true;
            if (num % 2 == 0 && set.contains(num / 2))
                return true;
            set.add(num);
        }
        return false;
    }
}
