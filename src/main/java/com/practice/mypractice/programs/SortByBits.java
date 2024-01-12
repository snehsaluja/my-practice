package com.practice.mypractice.programs;

import java.util.Arrays;

public class SortByBits {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        SortByBits ob = new SortByBits();
        int[] res = ob.sortByBits(arr);
        Arrays.stream(res).forEach(value -> {
            System.out.print(value + " ");
        });
    }


    public int[] sortByBits(int[] arr) {
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = countBits(arr[i]) * 10001 + arr[i];
        }
        Arrays.sort(res);
        for (int i = 0; i < arr.length; i++) {
            res[i] %= 10001;
        }
        return res;
    }

    private int countBits(int i) {
        int res = 0;
        while (i > 0) {
            res += i % 2;
            i /= 2;
        }
        return res;
    }
}
