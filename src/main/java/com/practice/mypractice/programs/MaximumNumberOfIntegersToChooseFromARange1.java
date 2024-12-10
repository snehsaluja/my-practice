package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOfIntegersToChooseFromARange1 {

    public static void main(String[] args) {

    }

    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] isBanned = new boolean[10001];
        int sum = 0, count = 0;

        for (int b : banned) {
            isBanned[b] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (sum + i > maxSum) {
                break;
            }
            if (!isBanned[i]) {
                sum += i;
                count++;
            }

        }
        return count;
    }

}
