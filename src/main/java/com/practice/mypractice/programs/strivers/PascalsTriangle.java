package com.practice.mypractice.programs.strivers;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(6));
        System.out.println("The element at position (r,c) is: " + getPascalRCValue(5, 3));
        printPascalRow(1);
        printPascalRow(2);
        printPascalRow(3);
        printPascalRow(4);
        printPascalRow(5);
        printPascalRow(6);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> insideList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    insideList.add(1);
                } else {
                    insideList.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(insideList);
        }
        return lists;
    }

    public static int getPascalRCValue(int r, int c) {
        return (int) nCr(r - 1, c - 1);
    }

    public static void printPascalRow(int r) {
        long res = 1;
        System.out.print(res + " ");
        for (int i = 1; i < r; i++) {
            res = res * (r - i);
            res = res / (i);
            System.out.print(res + " ");
        }
        System.out.println();
    }

    private static long nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}
