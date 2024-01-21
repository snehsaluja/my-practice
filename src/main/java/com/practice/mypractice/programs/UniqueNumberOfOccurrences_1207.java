package com.practice.mypractice.programs;

import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfOccurrences_1207 {

    public boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] + 1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int f : freq) {
            if (f != 0 && !set.add(f)) {
                return false;
            }
        }
        // OR :
        /*
            boolean[] used = new boolean[1001];
            for (int i : arr) {
            int count = freq[1000 + i]; // go through the original array
            freq[1000 + i] = 0; // take out the number of repetitions and zero it
            if (count > 0) {
                if (used[count]) return false;
                else used[count] = true;
            }
        }*/
        return true;
    }

    public static void main(String[] args) {

    }
}
