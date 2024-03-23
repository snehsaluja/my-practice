package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        for (int n : nums2) {
            if (set.contains(n))
                set2.add(n);
        }
        return set2.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                list.add(n);
                set.remove(n);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int[] intersectionLeetCodeStyle(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        for (int n : nums1) {
            freq[n]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (freq[n] > 0) {
                list.add(n);
                freq[n] = 0;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
