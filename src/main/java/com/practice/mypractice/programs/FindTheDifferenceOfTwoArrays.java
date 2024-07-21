package com.practice.mypractice.programs;

import com.practice.mypractice.programs.basics.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        for (int n : nums1) {
            if (!set2.contains(n)) {
                list1.add(n);
            }
        }
        for (int n : nums2) {
            if (!set1.contains(n)) {
                list2.add(n);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(list1));
        result.add(new ArrayList<>(list2));
        return result;
    }

    public List<List<Integer>> findDifference_2(int[] nums1, int[] nums2) {
        boolean[] flag1 = new boolean[2001];
        boolean[] flag2 = new boolean[2001];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int n : nums1) {
            flag1[n + 1000] = true;
        }
        for (int n : nums2) {
            flag2[n + 1000] = true;
            if (!flag1[n + 1000]) {
                list2.add(n);
                flag1[n + 1000] = true;         // to avoid duplicates
            }
        }
        for (int n : nums1) {
            if (!flag2[n + 1000]) {
                list1.add(n);
                flag2[n + 1000] = true;         // to avoid duplicates
            }
        }
        return List.of(list1, list2);
    }

    public static void main(String[] args) {

    }
}
