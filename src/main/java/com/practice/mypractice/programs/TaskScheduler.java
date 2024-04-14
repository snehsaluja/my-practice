package com.practice.mypractice.programs;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        Arrays.sort(freq);
        int batchCount = freq[25];                      // A _ _ _ A _ _ _ A  -> batch count is 3 and n is 3;
        int vacantSlots = (--batchCount) * n;           // decrement batch count and multiply with n =>  A _ _ _ A _ _ _ A => (3-1) * 3 = 6;
        for (int i = 0; i < 25; i++) {
            vacantSlots -= Math.min(freq[i], batchCount);   // this batch count is already decremented by 1
        }

        return (vacantSlots > 0) ? vacantSlots + tasks.length : tasks.length;
    }

    public static void main(String[] args) {

    }
}
