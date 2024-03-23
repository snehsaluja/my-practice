package com.practice.mypractice.programs;

public class PivotInteger {

    public int pivotInteger(int n) {

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i + arr[i - 1];
        }

        for (int i = n; i > 0; i--) {
            if (arr[i] == arr[n] - arr[i - 1])
                return i;
        }
        return -1;
    }

    public int pivotInteger2(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i + arr[i - 1];
        }
        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum += i;
            if (sum == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotInteger obj = new PivotInteger();
        System.out.println(obj.pivotInteger(8));
        System.out.println(obj.pivotInteger(1));
        System.out.println(obj.pivotInteger(4));
        System.out.println(obj.pivotInteger(410));
        System.out.println(obj.pivotInteger(10));
        System.out.println(obj.pivotInteger(500));
        System.out.println(obj.pivotInteger(1000));
    }

}
