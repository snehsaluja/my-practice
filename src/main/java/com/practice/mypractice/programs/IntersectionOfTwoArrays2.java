package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        for (int n : nums1) {
            freq[n]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (freq[n] > 0) {
                list.add(n);
                freq[n]--;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        int[] result = new int[1001];
        for (int n : nums1) {
            freq[n]++;
        }
        int counter = 0;
        for (int n : nums2) {
            if (freq[n] > 0) {
                result[counter++] = n;
                freq[n]--;
            }
        }
        return Arrays.copyOf(result, counter);
    }

    public int[] intersect_hashMapTechnique(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] result = new int[1001];
        int counter = 0;
        for (int n : nums1) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            int freqOfNumber = freq.getOrDefault(n, 0);
            if (freqOfNumber > 0) {
                result[counter++] = n;
                freq.put(n, freqOfNumber - 1);
            }
        }
        return Arrays.copyOf(result, counter);
    }

    public static void main(String[] args) {

    }
}
