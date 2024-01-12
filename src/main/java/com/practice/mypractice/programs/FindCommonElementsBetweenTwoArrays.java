package com.practice.mypractice.programs;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsBetweenTwoArrays {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] ans = {0, 0};
        int count1 = 0, count2 = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
            if (set1.contains(nums2[i])) {
                count2++;
            }
        }
        ans[1] = count2;
        for (int i = 0; i < nums1.length; i++) {
            if (set2.contains(nums1[i])) {
                count1++;
            }
        }
        ans[0] = count1;
        return ans;
    }
}
