package com.practice.mypractice.interview36;


import java.util.Arrays;


// saviynt round 1:

public class Solution {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 5;
        System.out.println(Arrays.toString(arr));
        reverse(arr, n);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.stream(arr).boxed().filter(k -> k < 5).map(k -> k * k).reduce(Integer::sum).get());
    }

    private static void reverse(int[] arr, int n) {
        int len = arr.length;
        int i = len - n, j = len - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // 2 inputs : int[]{ 1,2,3,4,5,6,7,8,9,10 } , int n = 5;
    // output: 1,2,3,4,5,10,9,8,7,6
}


// Table A          Table B
// c1, c2, c3       c4,c5,c6


// left outer join A and B on c1=c4:

// c1,c2,c3,c4,c5,c6
//


