package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindThePrefixCommonArrayOfTwoArrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, count = 0;
        int[] arr = new int[n];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(A[i]);
            set2.add(B[i]);
            if (A[i] == B[i]) {
                count++;
            } else {
                if (set1.contains(B[i]))
                    count++;
                if (set2.contains(A[i]))
                    count++;
            }
            arr[i] = count;
        }
        return arr;
    }

    public int[] findThePrefixCommonArray2(int[] A, int[] B) {
        int n = A.length, count = 0;
        int[] arr = new int[n + 1];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            arr[A[i]]++;
            if (arr[A[i]] == 2)
                count++;
            arr[B[i]]++;
            if (arr[B[i]] == 2)
                count++;
            result[i] = count;
        }
        return result;
    }

    public int[] findThePrefixCommonArray3(int[] A, int[] B) {
        int n = A.length, count = 0;
        int[] arr = new int[n + 1];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (++arr[A[i]] == 2)
                count++;
            if (++arr[B[i]] == 2)
                count++;
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
