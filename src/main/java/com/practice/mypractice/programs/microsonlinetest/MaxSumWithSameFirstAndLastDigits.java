package com.practice.mypractice.programs.microsonlinetest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSumWithSameFirstAndLastDigits {

    public int solution(int[] A) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int numOfDigits = countDigits(A[i]);
            int firstDigit = A[i] / (int) Math.pow(10, (numOfDigits - 1));
            int lastDigit = A[i] % 10;
            int key = (firstDigit * 10) + lastDigit;
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(A[i]);
        }

        int max = -1;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list, Comparator.reverseOrder());
            if (list.size() >= 2) {
                max = Math.max(max, list.get(0) + list.get(1));
            }
        }

        return max;

    }

    private int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }


    public static void main(String[] args) {

        /*
        [113, 113, 193, 90, 10]
        [279, 2499, 29, 2091]
        [60, 17, 187, 12871]
        [158, 168, 48, 148, 10848, 18]
        [10, 108, 26, 731]
        [56, 589, 599, 8765]
        [4567, 7654]
        [1708, 1479, 10247, 529409, 1092437]]
        */
        //int arr[] = {130, 191, 200, 10};
        int arr[] = {158, 168, 48, 148, 10848, 18};
        MaxSumWithSameFirstAndLastDigits obj = new MaxSumWithSameFirstAndLastDigits();
        System.out.println(obj.solution(arr));

    }
}
