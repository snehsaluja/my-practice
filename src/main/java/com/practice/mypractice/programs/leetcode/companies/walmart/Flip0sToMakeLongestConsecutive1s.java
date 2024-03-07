package com.practice.mypractice.programs.leetcode.companies.walmart;

import java.util.ArrayList;
import java.util.List;

public class Flip0sToMakeLongestConsecutive1s {

    public static void main(String[] args) {

        System.out.println(countLenWithFlip(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));

    }

    public static int countLenWithFlip(int[] arr, int k) {
        int bestWindow = 0, left = 0, right = 0, zeroesCount = 0, bestLeft = 0;

        while (right < arr.length) {
            if (zeroesCount <= k) {
                if (arr[right] == 0) {
                    zeroesCount++;
                }
                right++;
            }

            if (zeroesCount > k) {
                if (arr[left] == 0) {
                    zeroesCount--;
                }
                left++;
            }

            if (right - left > bestWindow && zeroesCount <= k) {
                bestWindow = right - left;
                bestLeft = left;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bestWindow; i++) {
            if (arr[i + bestLeft] == 0) {
                list.add(i + bestLeft);
            }
        }
        System.out.println("List of zero-indexes to be flipped = " + list);

        return bestWindow;
    }
}
